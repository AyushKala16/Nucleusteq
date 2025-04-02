import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { AuthProvider } from './context/AuthContext';
import ProtectedRoute from './components/ProtectedRoute';
import Navbar from './components/Navbar';
import Login from './pages/Login';
import Register from './pages/Register';
import StudentDashboard from './pages/StudentDashboard';
import OfficerDashboard from './pages/OfficerDashboard';
import AdminDashboard from './pages/AdminDashboard';
import AvailableSeats from './pages/AvailableSeats';
import OfficerSeatSettings from './pages/OfficerSeatSettings';
import StudentApplicationStatus from './components/StudentApplicationStatus';
import ManageOfficers from './pages/ManageOfficers';
import Home from './pages/Home';
import UpdateStudent from './pages/UpdateStudent';

function App() {

  return (
    <AuthProvider>
      <Router>
        <Navbar />
        <Routes>
          <Route path='/' element={<Home />}/>
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path='/seats' element={<AvailableSeats/>}/>
          <Route
            path="/student"
            element={
              <ProtectedRoute roles={['STUDENT']}>
                <StudentDashboard />
                
              </ProtectedRoute>
            }
          />
          <Route
            path="/student/applicationStatus"
            element={
              <ProtectedRoute roles={['STUDENT']}>
                <StudentApplicationStatus />
                
              </ProtectedRoute>
            }
          />
          <Route
            path="/officer"
            element={
              <ProtectedRoute roles={['OFFICER']}>
                <OfficerDashboard />
              </ProtectedRoute>
            }
          />
          <Route
            path="/officer/updateStudent/:email"
            element={
              <ProtectedRoute roles={['OFFICER']}>
                <UpdateStudent />
              </ProtectedRoute>
            }
          />

          <Route
            path="/officer/seats"
            element={
              <ProtectedRoute roles={['OFFICER']}>
                <OfficerSeatSettings/>
              </ProtectedRoute>
            }
          />

          <Route
            path="/manage-officers"
            element={
              <ProtectedRoute roles={['ADMIN']}>
                <ManageOfficers />
              </ProtectedRoute>
            }
          />
          <Route
            path="/admin"
            element={
              <ProtectedRoute roles={['ADMIN']}>
                <AdminDashboard />
              </ProtectedRoute>
            }
          />
        </Routes>
      </Router>
    </AuthProvider>
  );
}

export default App;