import axios from 'axios';

const api = axios.create({
  baseURL: import.meta.env.VITE_API_BASE_URL || '/api',
});

export const createComplaint = (complaint) => api.post('/complaints/add', complaint);
export const getAllComplaints = () => api.get('/complaints/getAll');
