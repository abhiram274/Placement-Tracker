import api from "./axios";

export const getSkills = () => {
  return api.get("/api/student/skills");
};

export const addSkill = (name, level) => {
  return api.post("/api/student/skills", {
    name,
    level
  });
};
