import React from 'react';
import { AppBar, Toolbar, Typography, Button } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';

const Navbar = () => {
  const { user, logout } = useAuth();
  const navigate = useNavigate();

  return (
    <AppBar position="static">
      <Toolbar>
        <Typography variant="h6" style={{ flexGrow: 1 }}>
          College Admission Portal
        </Typography>
        {user ? (
          <>
            {user.data.role.toLowerCase() === "student" && (
              <>
                <Button color="inherit" onClick={() => navigate("/student")}>
                  Dashboard
                </Button>
                <Button
                  color="inherit"
                  onClick={() => navigate(`/student/applicationStatus`)}
                >
                  Check Status
                </Button>
                <Button color="inherit" onClick={() => navigate("/seats")}>
                  Available Seats
                </Button>
                <Button color="inherit" onClick={()=>{
                  logout();
                  navigate('/login');
                }}>
                  Logout
                </Button>
              </>
            )}

            {user.data.role.toLowerCase() === "officer" && (
              <>
                <Button color="inherit" onClick={() => navigate("/officer")}>
                  Officer Dashboard
                </Button>
                <Button color="inherit" onClick={() => navigate("/officer/seats")}>
                  Manage Seats
                </Button>
                <Button color="inherit" onClick={logout}>
                  Logout
                </Button>
              </>
            )}

            {user.data.role.toLowerCase() === "admin" && (
              <>
                <Button color="inherit" onClick={() => navigate("/admin")}>
                  Admin Dashboard
                </Button>
                <Button color="inherit" onClick={() => navigate("/manage-officers")}>
                  Manage Officers
                </Button>
                <Button color="inherit" onClick={logout}>
                  Logout
                </Button>
              </>
            )}
          </>
        ) : (
          <>
            <Button color="inherit" onClick={() => navigate('/login')}>
              Login
            </Button>
            <Button color="inherit" onClick={() => navigate('/register')}>
              Register
            </Button>
          </>
        )
        }
      </Toolbar>
    </AppBar>
  );
};

export default Navbar;