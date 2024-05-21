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

function DataTable({
  data,
  onSort,
  sortConfig,
  columns,
  checkedItems,
  handleCheckboxChange,
  handleSelectAll,
  offset,
}) {
  const [columnWidths, setColumnWidths] = useState({
    "log.level": 150,
    "@timestamp": 200,
    id: 150,
    type: 150,
    message: 200,
    component: 50,
  });

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
            {columns.map((key, index) => (
              <TableCell
                key={index}
                style={{ width: columnWidths[key], position: "relative" }}
                onClick={() => onSort(key)}
                className="table-cell resizable"
              >
                {key} {getSortDirection(key)}
                {key === "message" && (
                  <div onMouseDown={handleMouseDown(key)} className="resizer"></div>
                )}
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
              {columns.map((key, colIndex) => (
                <TableCell key={colIndex} className="table-cell">
                  {key === "message"
                    ? item[key].split("\n").map((line, index) => (
                        <span key={index}>
                          {line}
                          <br />
                        </span>
                      ))
                    : item[key] !== undefined
                    ? JSON.stringify(item[key])
                    : ""}
                </TableCell>
              ))}
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}

export default DataTable;
