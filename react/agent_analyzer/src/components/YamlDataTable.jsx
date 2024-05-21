import React, { useState } from "react";
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  Checkbox,
} from "@mui/material";
import "../styles/DataTable.css";

const MAX_CELL_LENGTH = 200;
const MAX_COLUMN_NAME_LENGTH = 10;

const formatCell = (cell) => {
  if (typeof cell === "string" && cell.length > MAX_CELL_LENGTH) {
    return cell.slice(0, MAX_CELL_LENGTH) + "...";
  } else if (typeof cell === "string") {
    return cell.split("\n").map((line, index) => <div key={index}>{line}</div>);
  }
  return JSON.stringify(cell, null, 2);
};

const formatColumnName = (name) => {
  if (name.length > MAX_COLUMN_NAME_LENGTH) {
    return name.slice(0, MAX_COLUMN_NAME_LENGTH) + "...";
  }
  return name;
};

function YamlDataTable({
  data,
  onSort,
  sortConfig,
  columnHeaders,
  checkedItems,
  handleCheckboxChange,
  handleSelectAll,
  offset,
}) {
  const [columnWidths, setColumnWidths] = useState(
    columnHeaders.reduce((acc, header) => {
      acc[header] = 150;
      return acc;
    }, {})
  );

  const handleMouseDown = (key) => (e) => {
    e.preventDefault();
    const startX = e.clientX;
    const startWidth = columnWidths[key];

    const onMouseMove = (e) => {
      const newWidth = startWidth + e.clientX - startX;
      setColumnWidths((prevWidths) => ({
        ...prevWidths,
        [key]: newWidth > 50 ? newWidth : 50, // Minimum width to prevent negative values
      }));
    };

    const onMouseUp = () => {
      document.removeEventListener("mousemove", onMouseMove);
      document.removeEventListener("mouseup", onMouseUp);
    };

    document.addEventListener("mousemove", onMouseMove);
    document.addEventListener("mouseup", onMouseUp);
  };

  const getSortDirection = (key) => {
    if (sortConfig.key !== key) return "";
    return sortConfig.direction === "asc" ? " ↑" : " ↓";
  };

  return (
    <TableContainer component={Paper} className="table-container">
      <Table className="table">
        <TableHead className="table-header">
          <TableRow>
            <TableCell>
              <Checkbox checked={checkedItems.size === data.length} onChange={handleSelectAll} />
            </TableCell>
            <TableCell>#</TableCell>
            {columnHeaders.map((header, index) => (
              <TableCell
                key={index}
                style={{ width: columnWidths[header], position: "relative" }}
                onClick={() => onSort(header)}
                className="table-cell resizable"
              >
                <div style={{ whiteSpace: "nowrap", overflow: "hidden", textOverflow: "ellipsis" }}>
                  {formatColumnName(header)} {getSortDirection(header)}
                </div>
                <div onMouseDown={handleMouseDown(header)} className="resizer"></div>
              </TableCell>
            ))}
          </TableRow>
        </TableHead>
        <TableBody>
          {data.map((item, rowIndex) => (
            <TableRow key={rowIndex}>
              <TableCell>
                <Checkbox
                  checked={checkedItems.has(rowIndex + offset)}
                  onChange={() => handleCheckboxChange(rowIndex + offset)}
                />
              </TableCell>
              <TableCell>{rowIndex + 1 + offset}</TableCell>
              {columnHeaders.map((header, colIndex) => (
                <TableCell key={colIndex} className="table-cell">
                  {item[header] !== undefined ? formatCell(item[header]) : ""}
                </TableCell>
              ))}
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}

export default YamlDataTable;
