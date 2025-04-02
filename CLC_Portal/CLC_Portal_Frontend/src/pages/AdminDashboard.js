import React, { useState } from 'react';
import { Container, Paper, Typography, TextField, Button } from '@mui/material';
import { createOfficer } from '../services/api';

const AdminDashboard = () => {
  const [officerData, setOfficerData] = useState({
    password: '',
    email: '',
    name: '',
  });

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await createOfficer(officerData);
      alert('Officer created successfully!');
      setOfficerData({ password: '', email: '', fullName: '' });
    } catch (error) {
      console.error('Failed to create officer:', error);
    }
  };

  return (
    <Container maxWidth="sm">
      <Paper elevation={3} style={{ padding: '2rem', marginTop: '2rem' }}>
        <Typography variant="h5" align="center" gutterBottom>
          Create New Admission Officer
        </Typography>
        <form onSubmit={handleSubmit}>
          <TextField
            fullWidth
            label="Full Name"
            margin="normal"
            value={officerData.name}
            onChange={(e) => setOfficerData({ ...officerData, name: e.target.value })}
          />
          <TextField
            fullWidth
            label="Email"
            type="email"
            margin="normal"
            value={officerData.email}
            onChange={(e) => setOfficerData({ ...officerData, email: e.target.value })}
          />
          <TextField
            fullWidth
            label="Password"
            type="password"
            margin="normal"
            value={officerData.password}
            onChange={(e) => setOfficerData({ ...officerData, password: e.target.value })}
          />
          <Button
            type="submit"
            variant="contained"
            color="primary"
            fullWidth
            style={{ marginTop: '1rem' }}
          >
            Create Officer
          </Button>
        </form>
      </Paper>
    </Container>
  );
};

export default AdminDashboard;