import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getAllStudents } from "../api/adminApi";
import { logout } from "../utils/auth";

function AdminDashboard() {
  const [students, setStudents] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    getAllStudents()
      .then(res => setStudents(res.data))
      .catch(() => alert("Access denied"));
  }, []);

  const handleLogout = () => {
    logout();
    navigate("/");
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Admin Dashboard</h2>

      {/* Navigation Buttons */}
      <div style={{ marginBottom: "20px" }}>
        <button 
          onClick={() => navigate("/admin/add-job")}
          style={{ marginRight: "10px", padding: "10px 20px", fontSize: "16px" }}
        >
          + Add Job
        </button>
        <button 
          onClick={() => navigate("/admin/applicants")}
          style={{ marginRight: "10px", padding: "10px 20px", fontSize: "16px" }}
        >
          View Applicants
        </button>
      </div>

      <h3>Students List</h3>
      <table border="1" style={{ width: "100%", borderCollapse: "collapse" }}>
        <thead>
          <tr style={{ backgroundColor: "#f0f0f0" }}>
            <th style={{ padding: "10px" }}>Name</th>
            <th style={{ padding: "10px" }}>Branch</th>
            <th style={{ padding: "10px" }}>Year</th>
            <th style={{ padding: "10px" }}>Eligible</th>
          </tr>
        </thead>
        <tbody>
          {students.map((s, index) => (
            <tr key={index}>
              <td style={{ padding: "10px" }}>{s.fullName}</td>
              <td style={{ padding: "10px" }}>{s.branch}</td>
              <td style={{ padding: "10px" }}>{s.year}</td>
              <td style={{ padding: "10px" }}>{s.eligible ? "Yes" : "No"}</td>
            </tr>
          ))}
        </tbody>
      </table>

      <br />
      <button 
        onClick={handleLogout}
        style={{ padding: "10px 20px", backgroundColor: "#ff6b6b", color: "white", cursor: "pointer" }}
      >
        Logout
      </button>
    </div>
  );
}

export default AdminDashboard;