import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Navigation from "./components/Navigation";
import LogAnalyzer from "./components/LogAnalyzer";
import YamlAnalyzer from "./components/YamlAnalyzer";
import "./App.css";

function Home() {
  return (
    <div className="center">
      <h1>Welcome to the Analyzer App</h1>
    </div>
  );
}

function NotFound() {
  return (
    <div className="center">
      <h1>Page Not Found</h1>
    </div>
  );
}

function App() {
  return (
    <Router>
      <div className="App">
        <Navigation />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/log-analyzer" element={<LogAnalyzer />} />
          <Route path="/yaml-analyzer" element={<YamlAnalyzer />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
