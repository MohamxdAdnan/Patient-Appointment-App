import './App.css';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import NavBar from './Components/NavBar/NavBar';




function App() {
  return (
    <div className="App">
      <Router>
        <NavBar />

        <Routes>
          <Route exact path="/login" element={<RegisterLogin  />} />
          <Route exact path="/listemployees" element={<ListEmployees/>} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
