import React from "react";
import { NavLink } from "react-router-dom";
import "../styles/Navigation.css";

function Navigation() {
  return (
    <nav className="navigation">
      <ul>
        <li>
          <NavLink to="/log-analyzer" className={({ isActive }) => (isActive ? "active" : "")}>
            Log Analyzer
          </NavLink>
        </li>
        <li>
          <NavLink to="/yaml-analyzer" className={({ isActive }) => (isActive ? "active" : "")}>
            YAML Analyzer
          </NavLink>
        </li>
      </ul>
    </nav>
  );
}

export default Navigation;
