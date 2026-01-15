import { useEffect, useState } from "react";
import { getProfile } from "../api/studentApi";
import { logout } from "../utils/auth";
import { getRoleFromToken } from "../utils/jwt";
import { useNavigate } from "react-router-dom";

function StudentProfile() {
    const navigate = useNavigate();
    const [profile, setProfile] = useState(null);
    const role = getRoleFromToken();

    useEffect(() => {
        getProfile()
            .then(res => setProfile(res.data))
            .catch(() => alert("Unauthorized"));
    }, []);

    if (!profile) return <p>Loading...</p>;

    return (
        <div>
            {role === "ADMIN" && (
                <button onClick={() => window.location.href = "/admin"}>
                    Admin Dashboard
                </button>
            )}
            <h2>Student Profile</h2>

            <p><b>Name:</b> {profile.fullName}</p>
            <p><b>Branch:</b> {profile.branch}</p>
            <p><b>Year:</b> {profile.year}</p>
            <p><b>Eligible:</b> {profile.eligible ? "Yes" : "No"}</p>

            <button onClick={() => window.location.href = "/skills"}>
                Go to Skills
            </button>

                      <button
        onClick={() => navigate("/student/jobs")}
        style={{
          padding: "10px 20px",
          fontSize: "16px",
          backgroundColor: "#1976d2",
          color: "white",
          border: "none",
          borderRadius: "4px",
          cursor: "pointer",
          marginTop: "15px",
        }}
      >
        View Available Jobs
      </button>
            <button onClick={logout}>Logout</button>
        </div>
    );
}

export default StudentProfile;
