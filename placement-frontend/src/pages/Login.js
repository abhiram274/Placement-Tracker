import { useState } from "react";
import { login } from "../api/authApi";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = async () => {
    try {
      const response = await login(username, password);
      localStorage.setItem("token", response.data.token);
      window.location.href = "/profile";
    } catch (err) {
      alert("Invalid credentials");
    }
  };


  return (
    <div>
      <h2>Login</h2>

      <input
        placeholder="Username"
        onChange={(e) => setUsername(e.target.value)}
      />
      <br />

      <input
        type="password"
        placeholder="Password"
        onChange={(e) => setPassword(e.target.value)}
      />
      <br />

      <button onClick={handleLogin}>Login</button>

      <button onClick={() => window.location.href = "/signup"}>
        Go to Signup
      </button>

    </div>


  );
}

export default Login;
