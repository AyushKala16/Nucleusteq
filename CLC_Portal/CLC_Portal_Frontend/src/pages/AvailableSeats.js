import React, { useState, useEffect } from 'react';
import { Container, Paper, Typography, TextField, Button, Grid, List, ListItem, ListItemText } from '@mui/material';
import { getSeats } from '../services/api';
import '../CSS/table.css';
const AvailableSeats = () => {
  const [seatData, setSeatData] = useState([]);

  useEffect(() => {
    loadSeats();
  }, []);

  const loadSeats = async () => {
    try {
      const response = await getSeats();
      setSeatData(response.data);
      console.log(response.data);
    } catch (error) {
      console.error('Failed to load seats:', error);
    }
  };


  return (
    <Container>
      <Grid container spacing={3}>
        
        <Grid item xs={24} md={24}>
          <Paper elevation={3} style={{ padding: '2rem', marginTop: '2rem' }}>
            <Typography variant="h5" gutterBottom>
              Available Seats
            </Typography>
            <table >
                <tr>

                <th>Branch</th>
                <th>Available Seats</th>
                </tr>
                
                {seatData.map((app, index) => (
                <tr>
                  <td style={
                    {
                        alignContent:"center",
                        alignItems:"center",
                        placeContent:"center",
                        placeItems:"center"
                        
                    }
                  }>
                  {app.branch}
                  </td>
                  <td>
                {app.vacantSeats}
                  </td>
                </tr>
              ))}
                
            </table>
          </Paper>
        </Grid>
      </Grid>
    </Container>
  );
};

export default AvailableSeats;