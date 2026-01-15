import api from "./axios";

// STUDENT
export const applyForJob = (jobId) => {
  return api.post(`/api/student/applications/apply/${jobId}`);
};

// ADMIN (pagination)
export const getApplicants = (jobId, page, size) => {
  return api.get(`/api/admin/applications/${jobId}?page=${page}&size=${size}`);
};

export const updateApplicationStatus = (applicationId, status) => {
  return api.put(`/api/admin/applications/${applicationId}/status/${status}`);
};
