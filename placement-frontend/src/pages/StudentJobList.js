import { useEffect, useState } from "react";
import { getAllJobs } from "../api/jobApi";
import { applyForJob } from "../api/applicationApi";

function StudentJobList() {
  
  const [jobs, setJobs] = useState([]);

  console.log(jobs);
  
  useEffect(() => {
    getAllJobs().then((res) => setJobs(res.data));
  }, []);

  const handleApply = async (jobId) => {
    try {
      await applyForJob(jobId);
      alert("Applied successfully");
    } catch {
      alert("Already applied or error");
    }
  };

  return (
    <div>
      <h2>Available Jobs</h2>

      <ul>
        {jobs.map((job) => (
          <li key={job.id}>
            <b>{job.roleName}</b> – {job.companyName}
            <br />
            Min Year: {job.minYear}
            <br />
            <button onClick={() => handleApply(job.id)}>Apply</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default StudentJobList;
