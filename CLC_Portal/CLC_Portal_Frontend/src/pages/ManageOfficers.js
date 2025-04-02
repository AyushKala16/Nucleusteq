import React, { useEffect, useState } from "react";
import { getOfficers, removeOfficer } from "../services/api";

const ManageOfficers = () => {
  const [officers, setOfficers] = useState([]);

  useEffect(() => {
    fetchOfficers();
  }, []);

  // Function to delete an officer
  const handleDelete = async(email) => {
    await removeOfficer(email);
    fetchOfficers();

  };

  const fetchOfficers=async()=>{
   const response =  await getOfficers();
   setOfficers(response.data);
  }

  
  return (
    <div className="container">
      <h2 className="title">Manage Officers</h2>
      <table className="officer-table">
        <thead>
          <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {officers.map((officer) => (
            <tr key={officer.email}>
              <td>{officer.name}</td>
              <td>{officer.email}</td>
              <td>
                <button className="delete-btn" onClick={() => handleDelete(officer.email)}>
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ManageOfficers;
