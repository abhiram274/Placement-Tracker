import { useState } from "react";
import { addJob } from "../api/jobApi";

function AdminAddJob() {
  // console.log("Current Role:", getRoleFromToken());
  // console.log("Token:", localStorage.getItem("token"));

  const [companyName, setCompanyName] = useState("");
  const [roleName, setRoleName] = useState("");
  const [minYear, setMinYear] = useState("");
  const [description, setDescription] = useState("");

  const handleSubmit = async () => {
    if (!companyName || !roleName || !minYear) {
      alert("Please fill all required fields");
      return;
    }

    try {
      await addJob({
        companyName,
        roleName,
        minYear,
        description,
      });
      alert("Job added successfully");
      setCompanyName("");
      setRoleName("");
      setMinYear("");
      setDescription("");
    } catch (error) {
      alert("Failed to add job: " + error.message);
    }
  };

  return (
    <div style={{ padding: "20px", maxWidth: "500px" }}>
      <h2>Admin – Add Job</h2>

      <div style={{ marginBottom: "15px" }}>
        <label style={{ display: "block", marginBottom: "5px", fontWeight: "bold" }}>
          Company Name:
        </label>
        <input
          type="text"
          placeholder="e.g., Google, Microsoft, Amazon"
          value={companyName}
          onChange={(e) => setCompanyName(e.target.value)}
          style={{ width: "100%", padding: "8px", boxSizing: "border-box" }}
        />
      </div>

      <div style={{ marginBottom: "15px" }}>
        <label style={{ display: "block", marginBottom: "5px", fontWeight: "bold" }}>
          Role Name:
        </label>
        <input
          type="text"
          placeholder="e.g., Software Engineer, Data Analyst"
          value={roleName}
          onChange={(e) => setRoleName(e.target.value)}
          style={{ width: "100%", padding: "8px", boxSizing: "border-box" }}
        />
      </div>

      <div style={{ marginBottom: "15px" }}>
        <label style={{ display: "block", marginBottom: "5px", fontWeight: "bold" }}>
          Experience Required:
        </label>
        <input
          type="text"
          placeholder="e.g., 2 years, 6 months, Fresher"
          value={minYear}
          onChange={(e) => setMinYear(e.target.value)}
          style={{ width: "100%", padding: "8px", boxSizing: "border-box" }}
        />
      </div>

      <div style={{ marginBottom: "15px" }}>
        <label style={{ display: "block", marginBottom: "5px", fontWeight: "bold" }}>
          Description (Optional):
        </label>
        <textarea
          placeholder="Job description, responsibilities, requirements..."
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          style={{ width: "100%", padding: "8px", minHeight: "100px", boxSizing: "border-box" }}
        />
      </div>

      <button 
        onClick={handleSubmit}
        style={{ 
          padding: "10px 20px", 
          fontSize: "16px", 
          cursor: "pointer",
          backgroundColor: "#4CAF50",
          color: "white",
          border: "none",
          borderRadius: "4px"
        }}
      >
        Add Job
      </button>
    </div>
  );
}

export default AdminAddJob;