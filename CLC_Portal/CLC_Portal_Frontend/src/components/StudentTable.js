import React from "react";
import "../CSS/StudentTable.css"; // Import external CSS

const StudentTable = ({students}) => {
    

  return (
    <div className="table-container">
      <h2 className="table-heading">Student Data</h2>
      <table className="student-table">
        <thead>
          <tr>
            <th>Rank</th>
            <th>Name</th>
            <th>Roll No</th>
            <th>Application Status</th>
          </tr>
        </thead>
        <tbody>
          {students.length > 0 ? (
            students.map((student, index) => (
              <tr key={index}>
                <td>{student.rank}</td>
                <td>{student.name}</td>
                <td>{student.rollNumber}</td>
                <td>
                  <span className={`status ${student.status.toLowerCase()}`}>
                    {student.status}
                  </span>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="4" className="no-data">
                No students found
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default StudentTable;
