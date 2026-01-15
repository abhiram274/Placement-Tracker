import api from "./axios";

export const login = (username, password) => {
  return api.post("/api/auth/login", { username, password });
};

export const signup = (data) => {
  return api.post("/api/auth/signup", data);
};
