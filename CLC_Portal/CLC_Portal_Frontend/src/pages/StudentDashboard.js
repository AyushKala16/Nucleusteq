import React, { useState, useEffect } from 'react';
import { Container} from '@mui/material';
import {getApplications } from '../services/api';
import StudentTable from '../components/StudentTable';

const StudentDashboard = () => {
  const [applicationData, setApplicationData] = useState({
    fullName: '',
    email: '',
    phone: '',
    address: '',
    previousSchool: '',
    gpa: '',
    desiredProgram: ''
  });
  const [topApplications, setTopApplications] = useState([]);

  useEffect(() => {
    loadTopApplications();
  }, []);

  const loadTopApplications = async () => {
    try {
      const response = await getApplications();
      
      // Filter only pending applications
      const pendingApplications = response.data.filter(app => app.status === "pending");
  
      // Sort by rank (assuming lower rank is better)
      pendingApplications.sort((a, b) => a.rank - b.rank);
  
      // Slice the top 15 applications
      setTopApplications(pendingApplications.slice(0, 15));
    } catch (error) {
      console.error("Failed to load applications:", error);
    }
  };


  return (
    <Container>
      <StudentTable students={topApplications}></StudentTable>
    </Container>
  );
};

export default StudentDashboard;