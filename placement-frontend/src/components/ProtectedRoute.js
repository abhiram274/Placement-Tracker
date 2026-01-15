import { Navigate } from "react-router-dom";
import { isLoggedIn } from "../utils/auth";
import { getRoleFromToken } from "../utils/jwt";

const ProtectedRoute = ({ children, requiredRole = null }) => {
  if (!isLoggedIn()) {
    return <Navigate to="/" />;
  }

  // If a specific role is required, check it
  if (requiredRole) {
    const userRole = getRoleFromToken();
    if (userRole !== requiredRole) {
      return <Navigate to="/" />;
    }
  }

  return children;
};

export default ProtectedRoute;