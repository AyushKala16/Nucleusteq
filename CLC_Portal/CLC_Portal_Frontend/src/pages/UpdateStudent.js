import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { fetchStudentDetails, updateStudentDetails } from "../services/api";
import "../CSS/UpdateStudent.css"; // Import CSS

const UpdateStudent = () => {
  const { email } = useParams();
  const navigate = useNavigate();
  const [studentDetails, setStudentDetails] = useState({
    name: "",
    fatherName: "",
    dob: "",
    email: "",
    branch: "",
    rank: "",
    phone: "",
    address: "",
    status: "",
    password: "",
  });

  useEffect(() => {
    getDetails();
  }, []);

  const getDetails = async () => {
    try {
      const response = await fetchStudentDetails(email);
      setStudentDetails(response.data);
    } catch (error) {
      console.error("Failed to fetch student details", error);
    }
  };

  const handleChange = (e) => {
    setStudentDetails({ ...studentDetails, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await updateStudentDetails(studentDetails);
      alert("Student details updated successfully!");
      navigate("/officer"); // Redirect to officer page
    } catch (error) {
      console.error("Failed to update student details", error);
    }
  };

  return (
    <div className="update-student-container">
      <h2>Update Student Details</h2>
      <form className="update-student-form" onSubmit={handleSubmit}>
        <label>Name:</label>
        <input type="text" name="name" value={studentDetails.name} onChange={handleChange} required />

        <label>Father Name:</label>
        <input type="text" name="fatherName" value={studentDetails.fatherName} onChange={handleChange} required />

        <label>Date of Birth:</label>
        <input type="date" name="dob" value={studentDetails.dob} onChange={handleChange} required />

        <label>Branch:</label>
        <input type="text" name="branch" value={studentDetails.branch} onChange={handleChange} required />

        <label>Rank:</label>
        <input type="number" name="rank" value={studentDetails.rank} onChange={handleChange} required />

        <label>Phone:</label>
        <input type="text" name="phone" value={studentDetails.phone} onChange={handleChange} required />

        <label>Address:</label>
        <input type="text" name="address" value={studentDetails.address} onChange={handleChange} required />

        <label>Status:</label>
        <input type="text" name="status" value={studentDetails.status} onChange={handleChange} required />

        <button type="submit">Update</button>
      </form>
    </div>
  );
};

export default UpdateStudent;
