import api from "./axios";

// STUDENT
export const getAllJobs = () => {
  return api.get("/api/student/jobs");
};

// ADMIN
export const addJob = (job) => {
  return api.post("/api/admin/jobs", job);
};