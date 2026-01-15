import api from "./axios";

export const getAllStudents = () => {
  return api.get("/api/admin/students");
};

export const getAllCompanies = () => {
  return api.get("/api/admin/companies");
};