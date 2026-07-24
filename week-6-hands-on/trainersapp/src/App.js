import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './Components/Home';
import TrainersList from './Components/TrainersList';
import TrainerDetails from './Components/TrainerDetails';
import trainersMock from './trainersmock';

function App() {
  return (
    <BrowserRouter>
      <div style={{ padding: '20px' }}>
        <h1>My Academy Trainers App</h1>
        <nav style={{ marginBottom: '15px' }}>
          <Link to="/">Home</Link> | <Link to="/trainers">Show Trainers</Link>
        </nav>
        <hr />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainersList trainers={trainersMock} />} />
          <Route path="/trainers/:id" element={<TrainerDetails trainers={trainersMock} />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;