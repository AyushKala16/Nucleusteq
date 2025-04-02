import React, { useEffect, useState } from "react";
import "../CSS/StudentApplicationStatus.css"; // Import external CSS
import { useAuth } from "../context/AuthContext";
import { fetchStudentDetails } from "../services/api";
const StudentApplicationStatus = () => {
  const [student, setStudent] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");
  const {user} = useAuth();

  useEffect(() => {
    func();
      
    setLoading(false);
  }, []);
const func = async ()=>{
    console.log(user.data.email)
    const response = await fetchStudentDetails(user.data.email);
      setStudent(response.data);
}
  return (
    <div className="status-container">
      <h2 className="status-heading">Application Status</h2>
      {loading ? (
        <p className="loading">Loading...</p>
      ) : error ? (
        <p className="error">{error}</p>
      ) : student ? (
        <div className="student-details">
          <p><strong>Name:</strong> {student.name}</p>
          <p><strong>Roll Number:</strong> {student.rollNumber}</p>
          <p><strong>Rank:</strong> {student.rank}</p>
          <p><strong>Branch:</strong> {student.branch}</p>
          <p><strong>Email:</strong> {student.email}</p>
          <p>
            <strong>Status:</strong>{" "}
            <span className={`status ${student.status.toLowerCase()}`}>
              {student.status}
            </span>
          </p>
        </div>
      ) : (
        <p className="error">No student found.</p>
      )}
    </div>
  );
};

export default StudentApplicationStatus;
