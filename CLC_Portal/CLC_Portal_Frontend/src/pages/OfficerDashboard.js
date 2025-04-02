import React, { useState, useEffect } from 'react';
import { Container, Paper, Typography, List, ListItem, ListItemText, Button } from '@mui/material';
import { getApplications, approveApplication,rejectApplication,} from '../services/api';
import { useNavigate } from 'react-router-dom';

const OfficerDashboard = () => {
  const [applications, setApplications] = useState([]);
  const navigate = useNavigate();
  useEffect(() => {
    loadApplications();
  }, []);

  const loadApplications = async () => {
    try {
      const response = await getApplications();
      // Filter only pending applications
      const pendingApplications = response.data.filter(app => app.status === "pending");
    
      // Sort by rank
      pendingApplications.sort((a, b) => a.rank - b.rank);
  
      // Slice the top 15 applications
      setApplications(pendingApplications.slice(0, 15))
      // setApplications(response.data);
    } catch (error) {
      console.error('Failed to load applications:', error);
    }
  };


  const handleApprove = async (id) => {
    try {
      console.log(id)
      await approveApplication(id);
      loadApplications();
    } catch (error) {
      console.error('Failed to approve application:', error);
    }
  };
  const handleReject = async (id) => {
    try {
      await rejectApplication(id);
      loadApplications();
    } catch (error) {
      console.error('Failed to approve application:', error);
    }
  };
  
  const handleEdit = async (email) => {
    try {
      navigate(`updateStudent/${email}`);
    } catch (error) {
      console.error('Failed to approve application:', error);
    }
  };

  return (
    <Container>
      <Paper elevation={3} style={{ padding: '2rem', marginTop: '2rem' }}>
        <Typography variant="h5" gutterBottom>
          Applications List
        </Typography>
        <List>
          {applications.map((app) => (
            <ListItem key={app.email}>
              <ListItemText
                primary={app.name}
                secondary={`Branch: ${app.branch} | Rank: ${app.rank} | Status: ${app.status}`}
              />
              {app.status.toUpperCase() === 'PENDING' && (
                <div>
                <Button
                style={{ margin: '.5rem' }}
                variant="contained"
                color="primary"
                
                onClick={() => handleApprove(app.email)}
                >
                  Approve
                </Button>
                <Button
                style={{ margin: '.5rem' }}
                variant="contained"
                color="primary"
                
                onClick={() => handleReject(app.email)}
                >
                  Reject
                </Button>
                <Button
                style={{ margin: '.5rem' }}
                variant="contained"
                color="primary"
                
                onClick={() => handleEdit(app.email)}
                >
                  Edit
                </Button>
                  </div>
                
              )}
            </ListItem>
          ))}
        </List>
      </Paper>
    </Container>
  );
};

export default OfficerDashboard;