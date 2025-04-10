import React, { useState } from 'react';
import { TextField, Button, Container, Paper, Typography, FormControl,InputLabel,MenuItem,Select} from '@mui/material';
import { useNavigate } from 'react-router-dom';
import { register } from '../services/api';

const Register = () => {
  const [userData, setUserData] = useState({
    rollNumber: '',
    name: '',
    fatherName: '',
    dob: '',
    rank: '',
    phone: '',
    address: '',
    email: '',
    password: '',
    branch: '',
    status: "PENDING"
  });
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await register(userData);
      navigate('/login');
    } catch (error) {
      console.error('Registration failed:', error);
    }
  };

  return (
    <Container maxWidth="sm">
      <Paper elevation={3} style={{ padding: '2rem', marginTop: '2rem' }}>
        <Typography variant="h5" align="center" gutterBottom>
          Register
        </Typography>
        <form onSubmit={handleSubmit}>
          <TextField
            fullWidth
            label="Full Name"
            margin="normal"
            required
            value={userData.name}
            onChange={(e) => setUserData({ ...userData, name: e.target.value })}
          />
          <TextField
            fullWidth
            label="FatherName"
            margin="normal"
            required
            value={userData.fatherName}
            onChange={(e) => setUserData({ ...userData, fatherName: e.target.value })}
          />
          <TextField
            fullWidth
            label="Roll Number"
            margin="normal"
            required
            value={userData.rollNumber}
            onChange={(e) => setUserData({ ...userData, rollNumber: e.target.value })}
          />
          <TextField
            fullWidth
            label="Rank"
            margin="normal"
            required
            value={userData.rank}
            onChange={(e) => setUserData({ ...userData, rank: e.target.value })}
          />
          <TextField
            fullWidth
            label="DOB"
            type="date"
            margin="normal"
            required
            value={userData.dob}
            onChange={(e) => setUserData({ ...userData, dob: e.target.value })}
          />
          <TextField
            fullWidth
            label="Phone Number"
            margin="normal"
            required
            value={userData.phone}
            onChange={(e) => setUserData({ ...userData, phone: e.target.value })}
          />
          <TextField
            fullWidth
            label="Address"
            margin="normal"
            required
            value={userData.address}
            onChange={(e) => setUserData({ ...userData, address: e.target.value })}
          />
          {/* Dropdown for Branch */}
          <FormControl fullWidth margin="normal" required>
            <InputLabel id="branch-label">Branch</InputLabel>
            <Select
              labelId="branch-label"
              value={userData.branch}
              label="Branch"
              onChange={(e) => setUserData({ ...userData, branch: e.target.value })}
            >
              <MenuItem value="Computer Engineering">Computer Engineering</MenuItem>
              <MenuItem value="Information Technology">Information Technology</MenuItem>
              <MenuItem value="Electronics Engineering">Electronics Engineering</MenuItem>
              <MenuItem value="Mechanical Engineering">Mechanical Engineering</MenuItem>
              <MenuItem value="Civil Engineering">Civil Engineering</MenuItem>
              <MenuItem value="Instrumentation Engineering">Instrumentation Engineering</MenuItem>
              <MenuItem value="AI & Data Science">AI & Data Science</MenuItem>
            </Select>
          </FormControl>
          <TextField
            fullWidth
            label="Email"
            type="email"
            margin="normal"
            required
            value={userData.email}
            onChange={(e) => setUserData({ ...userData, email: e.target.value })}
          />
          <TextField
            fullWidth
            label="Password"
            type="password"
            margin="normal"
            required
            value={userData.password}
            onChange={(e) => setUserData({ ...userData, password: e.target.value })}
          />
          <Button
            type="submit"
            variant="contained"
            color="primary"
            fullWidth
            style={{ marginTop: '1rem' }}
          >
            Register
          </Button>
        </form>
      </Paper>
    </Container>
  );
};

export default Register;