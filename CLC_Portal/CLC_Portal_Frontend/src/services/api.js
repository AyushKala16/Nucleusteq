import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api';

const api = axios.create({
  baseURL: API_BASE_URL,
});

export const login = (credentials) => api.post('/users/login', credentials);
export const register = (userData) => api.post('/students/register', userData);
export const getApplications = () => api.get('/students');
export const fetchStudentDetails = (email) => api.get('/students/detail?email=' + email);
export const getSeats = () => api.get('/seats');
export const updateStudentDetails = (studentDetails) => api.put('/students/update', studentDetails);

export const setSeats = (branch, change) => {api.put('/seats/update',{branch,change})};
export const approveApplication = (id) => api.put('/students/applications/approve?email='+id,id);

export const rejectApplication = (id) => api.put(`/students/applications/reject?email=`+id,{});
export const createOfficer = (officerData) => api.post('/officers/add', officerData);
export const removeOfficer = (email)=>api.delete('/officers/removeofficer?email='+email);
export const getOfficers= ()=>api.get('/officers');


export default api;