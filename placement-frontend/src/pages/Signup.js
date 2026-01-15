import { useState } from "react";
import { signup } from "../api/authApi";

function Signup() {
  const [form, setForm] = useState({
    username: "",
    email: "",
    password: "",
    fullName: "",
    branch: "",
    year: ""
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSignup = async () => {
    try {
      await signup(form);
      alert("Signup successful. Please login.");
      window.location.href = "/";
    } catch {
      alert("Signup failed");
    }
  };

  return (
    <div>
      <h2>Signup</h2>

      <input name="username" placeholder="Username" onChange={handleChange} />
      <input name="email" placeholder="Email" onChange={handleChange} />
      <input type="password" name="password" placeholder="Password" onChange={handleChange} />
      <input name="fullName" placeholder="Full Name" onChange={handleChange} />
      <input name="branch" placeholder="Branch" onChange={handleChange} />
      <input name="year" placeholder="Year" onChange={handleChange} />

      <button onClick={handleSignup}>Signup</button>
    </div>
  );
}

export default Signup;
