import React from 'react';
import { useParams } from 'react-router-dom';

function TrainerDetails({ trainers }) {
  const { id } = useParams();
  const trainer = trainers.find((t) => t.trainerId === id);

  if (!trainer) {
    return <h3>Trainer details not found!</h3>;
  }

  return (
    <div>
      <h2>Trainers Details</h2>
      <h3>{trainer.name} ({trainer.technology})</h3>
      <p>{trainer.email}</p>
      <p>{trainer.phone}</p>
      <ul>
        {trainer.skills.map((skill, index) => (
          <li key={index}>{skill}</li>
        ))}
      </ul>
    </div>
  );
}

export default TrainerDetails;