import React, { useState, useMemo, useEffect } from "react";
import yaml from "js-yaml";
import Select from "react-select";
import ReactPaginate from "react-paginate";
import YamlDataTable from "./YamlDataTable";
import "../styles/YamlAnalyzer.css";

const ITEMS_PER_PAGE_OPTIONS = [
  { value: 10, label: "10" },
  { value: 25, label: "25" },
  { value: 50, label: "50" },
  { value: 100, label: "100" },
  { value: 150, label: "150" },
  { value: 200, label: "200" },
];

function YamlAnalyzer() {
  const [data, setData] = useState([]);
  const [sortConfig, setSortConfig] = useState({ key: null, direction: "asc" });
  const [currentPage, setCurrentPage] = useState(0);
  const [itemsPerPage, setItemsPerPage] = useState(50);
  const [fileLoaded, setFileLoaded] = useState(false);
  const [columnHeaders, setColumnHeaders] = useState([]);
  const [checkedItems, setCheckedItems] = useState(new Set());
  const [selectedColumns, setSelectedColumns] = useState([]);

  const COLUMNS_OPTIONS = columnHeaders.map((col) => ({ value: col, label: col }));

  useEffect(() => {
    setSelectedColumns(COLUMNS_OPTIONS);
  }, [columnHeaders]);

  const handleFileChange = (event) => {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = (e) => {
        const text = e.target.result;
        const parsedData = parseYAML(text);
        setData(parsedData);
        setFileLoaded(true);
      };
      reader.readAsText(file);
    }
  };

  const parseYAML = (text) => {
    try {
      const result = yaml.load(text);
      if (Array.isArray(result) && result.length > 0) {
        setColumnHeaders(Object.keys(result[0]));
        return result;
      } else if (typeof result === "object" && result !== null) {
        setColumnHeaders(Object.keys(result));
        return [result];
      } else {
        console.error("Unexpected YAML format");
        return [];
      }
    } catch (e) {
      console.error("Invalid YAML file", e);
      return [];
    }
  };

  const handleSort = (key) => {
    let direction = "asc";
    if (sortConfig.key === key && sortConfig.direction === "asc") {
      direction = "desc";
    }
    setSortConfig({ key, direction });
  };

  const sortedData = useMemo(() => {
    let sortableData = [...data];
    if (sortConfig.key !== null) {
      sortableData.sort((a, b) => {
        if (a[sortConfig.key] < b[sortConfig.key]) {
          return sortConfig.direction === "asc" ? -1 : 1;
        }
        if (a[sortConfig.key] > b[sortConfig.key]) {
          return sortConfig.direction === "asc" ? 1 : -1;
        }
        return 0;
      });
    }
    return sortableData;
  }, [data, sortConfig]);

  const filteredData = sortedData;

  const pageCount = Math.ceil(filteredData.length / itemsPerPage);
  const offset = currentPage * itemsPerPage;
  const currentPageData = filteredData.slice(offset, offset + itemsPerPage);

  const handlePageClick = ({ selected }) => {
    setCurrentPage(selected);
  };

  const handleItemsPerPageChange = (selectedOption) => {
    setItemsPerPage(selectedOption.value);
    setCurrentPage(0);
  };

  const handleCheckboxChange = (index) => {
    setCheckedItems((prevCheckedItems) => {
      const newCheckedItems = new Set(prevCheckedItems);
      if (newCheckedItems.has(index)) {
        newCheckedItems.delete(index);
      } else {
        newCheckedItems.add(index);
      }
      return newCheckedItems;
    });
  };

  const handleSelectAll = () => {
    if (checkedItems.size === currentPageData.length) {
      setCheckedItems(new Set());
    } else {
      const allItems = new Set(currentPageData.map((_, index) => index + offset));
      setCheckedItems(allItems);
    }
  };

  const handleColumnChange = (selectedOptions) => {
    setSelectedColumns(selectedOptions);
  };

  const exportCheckedItemsToJSON = () => {
    const checkedData = currentPageData.filter((_, index) => checkedItems.has(index + offset));
    const jsonBlob = new Blob([JSON.stringify(checkedData, null, 2)], { type: "application/json" });
    const url = URL.createObjectURL(jsonBlob);
    const a = document.createElement("a");
    a.setAttribute("hidden", "");
    a.setAttribute("href", url);
    a.setAttribute("download", "checked_items.json");
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
  };

  return (
    <div className="yaml-analyzer">
      <h1>YAML Analyzer</h1>
      <input type="file" accept=".yaml,.yml" onChange={handleFileChange} />
      <div className={`filters-container ${!fileLoaded ? "hidden" : ""}`}>
        <div className="select-container">
          <Select
            value={ITEMS_PER_PAGE_OPTIONS.find((option) => option.value === itemsPerPage)}
            onChange={handleItemsPerPageChange}
            options={ITEMS_PER_PAGE_OPTIONS}
            placeholder="Items per page"
          />
        </div>
        <div className="select-container column-selector">
          <Select
            isMulti
            value={selectedColumns}
            onChange={handleColumnChange}
            options={COLUMNS_OPTIONS}
            placeholder="Select columns"
          />
        </div>
        <div className="button-container">
          <button onClick={exportCheckedItemsToJSON}>Export Checked to JSON</button>
        </div>
      </div>
      {currentPageData.length > 0 && (
        <YamlDataTable
          data={currentPageData}
          onSort={handleSort}
          sortConfig={sortConfig}
          columnHeaders={selectedColumns.map((col) => col.value)}
          checkedItems={checkedItems}
          handleCheckboxChange={handleCheckboxChange}
          handleSelectAll={handleSelectAll}
          offset={offset}
        />
      )}
      <div className={!fileLoaded ? "hidden" : ""}>
        <ReactPaginate
          previousLabel={"previous"}
          nextLabel={"next"}
          breakLabel={"..."}
          pageCount={pageCount}
          marginPagesDisplayed={2}
          pageRangeDisplayed={3}
          onPageChange={handlePageClick}
          containerClassName={"pagination"}
          activeClassName={"active"}
          disabledClassName={"disabled"}
        />
      </div>
    </div>
  );
}

export default YamlAnalyzer;
