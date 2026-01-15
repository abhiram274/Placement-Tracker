import { useEffect, useState } from "react";
import {
  getApplicants,
  updateApplicationStatus,
} from "../api/applicationApi";

function AdminApplicants() {
  const [jobId, setJobId] = useState("");
  const [apps, setApps] = useState([]);
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);

  const loadApplicants = () => {
    getApplicants(jobId, page, 5)
      .then((res) => {
        setApps(res.data.content);
        setTotalPages(res.data.totalPages);
      })
      .catch(() => alert("403 – Login as ADMIN"));
  };

  useEffect(() => {
    if (jobId) loadApplicants();
  }, [page]);

  return (
    <div>
      <h2>Admin – Applicants</h2>

      <input
        placeholder="Job ID"
        value={jobId}
        onChange={(e) => {
          setJobId(e.target.value);
          setPage(0);
        }}
      />

      <button onClick={loadApplicants}>Load Applicants</button>

      <ul>
        {apps.map((a) => (
          <li key={a.applicationId}>
            {a.studentName} – {a.branch} – {a.status}
            <br />
            <button
              onClick={() =>
                updateApplicationStatus(a.applicationId, "ACCEPTED")
              }
            >
              Accept
            </button>
            <button
              onClick={() =>
                updateApplicationStatus(a.applicationId, "REJECTED")
              }
            >
              Reject
            </button>
          </li>
        ))}
      </ul>

      <button
        onClick={() => setPage(page - 1)}
        disabled={page === 0}
      >
        Prev
      </button>

      <button
        onClick={() => setPage(page + 1)}
        disabled={page + 1 >= totalPages}
      >
        Next
      </button>
    </div>
  );
}

export default AdminApplicants;
