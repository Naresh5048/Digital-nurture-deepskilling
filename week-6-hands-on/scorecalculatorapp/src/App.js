import React from 'react';
import { CalculateScore } from './Components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore 
        Name={"Naresh"}
        School={"Sri Chaitanya Techno School"}
        total={300}
        goal={3}
      />
    </div>
  );
}

export default App;