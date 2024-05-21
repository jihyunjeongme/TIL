import React, { useState, useMemo, useEffect } from "react";
import DataTable from "./DataTable";
import Select from "react-select";
import ReactPaginate from "react-paginate";
import "../styles/LogAnalyzer.css";

const ITEMS_PER_PAGE_OPTIONS = [
  { value: 10, label: "10" },
  { value: 25, label: "25" },
  { value: 50, label: "50" },
  { value: 100, label: "100" },
  { value: 150, label: "150" },
  { value: 200, label: "200" },
];

const COLUMNS_OPTIONS = [
  { value: "log.level", label: "log.level" },
  { value: "@timestamp", label: "@timestamp" },
  { value: "id", label: "id" },
  { value: "type", label: "type" },
  { value: "message", label: "message" },
  { value: "component", label: "component" },
];

function LogAnalyzer() {
  const [data, setData] = useState([]);
  const [sortConfig, setSortConfig] = useState({ key: null, direction: "asc" });
  const [currentPage, setCurrentPage] = useState(0);
  const [itemsPerPage, setItemsPerPage] = useState(50);
  const [fileLoaded, setFileLoaded] = useState(false);
  const [selectedLogLevel, setSelectedLogLevel] = useState({
    value: "All",
    label: "All log.level",
  });
  const [selectedId, setSelectedId] = useState({ value: "All", label: "All id" });
  const [selectedType, setSelectedType] = useState({ value: "All", label: "All type" });
  const [selectedMessage, setSelectedMessage] = useState({ value: "All", label: "All message" });
  const [selectedColumns, setSelectedColumns] = useState(COLUMNS_OPTIONS);
  const [checkedItems, setCheckedItems] = useState(new Set());

  const [filteredLogLevels, setFilteredLogLevels] = useState([]);
  const [filteredIds, setFilteredIds] = useState([]);
  const [filteredTypes, setFilteredTypes] = useState([]);
  const [filteredMessages, setFilteredMessages] = useState([]);

  useEffect(() => {
    if (data.length > 0) {
      setFileLoaded(true);
      setDefaultLogLevel();
      updateFilters();
    }
  }, [data]);

  useEffect(() => {
    updateFilters();
  }, [selectedLogLevel, selectedId, selectedType, selectedMessage]);

  const setDefaultLogLevel = () => {
    const logLevels = ["error", "warn", "info"];
    for (const level of logLevels) {
      if (data.some((item) => item["log.level"] === level)) {
        setSelectedLogLevel({ value: level, label: level });
        return;
      }
    }
    setSelectedLogLevel({ value: "All", label: "All log.level" });
  };

  const updateFilters = () => {
    let filteredData = data;

    if (selectedLogLevel.value !== "All") {
      filteredData = filteredData.filter((item) => item["log.level"] === selectedLogLevel.value);
    }
    if (selectedId.value !== "All") {
      filteredData = filteredData.filter((item) => item.id === selectedId.value);
    }
    if (selectedType.value !== "All") {
      filteredData = filteredData.filter((item) => item.type === selectedType.value);
    }
    if (selectedMessage.value !== "All") {
      filteredData = filteredData.filter((item) => item.message.includes(selectedMessage.value));
    }

    setFilteredLogLevels(
      Array.from(new Set(filteredData.map((item) => item["log.level"]))).map((level) => ({
        value: level,
        label: level,
      }))
    );
    setFilteredIds(
      Array.from(new Set(filteredData.map((item) => item.id))).map((id) => ({
        value: id,
        label: id,
      }))
    );
    setFilteredTypes(
      Array.from(new Set(filteredData.map((item) => item.type))).map((type) => ({
        value: type,
        label: type,
      }))
    );
    setFilteredMessages(
      Array.from(new Set(filteredData.map((item) => item.message))).map((message) => ({
        value: message,
        label: message,
      }))
    );
  };

  const handleFileChange = (event) => {
    const files = Array.from(event.target.files);
    let combinedData = [];

    files.forEach((file) => {
      const reader = new FileReader();
      reader.onload = (e) => {
        const text = e.target.result;
        const parsedData = parseNDJSON(text);
        combinedData = combinedData.concat(parsedData);
        if (files.indexOf(file) === files.length - 1) {
          setData(combinedData);
          setFileLoaded(true);
        }
      };
      reader.readAsText(file);
    });
  };

  const parseNDJSON = (text) => {
    const lines = text.split("\n").filter((line) => line.trim() !== "");
    return lines.map((line) => {
      try {
        const item = JSON.parse(line);
        if (item.component) {
          item.id = item.component.id;
          item.type = item.component.type;
        }
        return item;
      } catch (e) {
        return { error: "Invalid JSON", details: line };
      }
    });
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

  const filteredData = sortedData.filter((item) => {
    return (
      (selectedLogLevel.value === "All" || item["log.level"] === selectedLogLevel.value) &&
      (selectedId.value === "All" || item.id === selectedId.value) &&
      (selectedType.value === "All" || item.type === selectedType.value) &&
      (selectedMessage.value === "All" || item.message.includes(selectedMessage.value))
    );
  });

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

  const handleLogLevelChange = (selectedOption) => {
    setSelectedLogLevel(selectedOption);
  };

  const handleIdChange = (selectedOption) => {
    setSelectedId(selectedOption);
  };

  const handleTypeChange = (selectedOption) => {
    setSelectedType(selectedOption);
  };

  const handleMessageChange = (selectedOption) => {
    setSelectedMessage(selectedOption);
  };

  const handleColumnChange = (selectedOptions) => {
    setSelectedColumns(selectedOptions);
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
    <div className="log-analyzer">
      <h1>Log Analyzer</h1>
      <input type="file" accept=".ndjson" multiple onChange={handleFileChange} />
      <div className={`filters-container ${!fileLoaded ? "hidden" : ""}`}>
        <div className="select-container">
          <Select
            value={selectedLogLevel}
            onChange={handleLogLevelChange}
            options={[{ value: "All", label: "All log.level" }, ...filteredLogLevels]}
            placeholder="Select log.level"
          />
        </div>
        <div className="select-container">
          <Select
            value={selectedId}
            onChange={handleIdChange}
            options={[{ value: "All", label: "All id" }, ...filteredIds]}
            placeholder="Select id"
          />
        </div>
        <div className="select-container">
          <Select
            value={selectedType}
            onChange={handleTypeChange}
            options={[{ value: "All", label: "All type" }, ...filteredTypes]}
            placeholder="Select type"
          />
        </div>
        <div className="select-container">
          <Select
            value={selectedMessage}
            onChange={handleMessageChange}
            options={[{ value: "All", label: "All message" }, ...filteredMessages]}
            placeholder="Select message"
          />
        </div>
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
        <button onClick={exportCheckedItemsToJSON}>Export Checked to JSON</button>
      </div>
      {currentPageData.length > 0 && (
        <DataTable
          data={currentPageData}
          onSort={handleSort}
          sortConfig={sortConfig}
          columns={selectedColumns.map((col) => col.value)}
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

export default LogAnalyzer;
