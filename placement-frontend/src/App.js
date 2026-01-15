import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./pages/Login";
import StudentProfile from "./pages/StudentProfile";
import ProtectedRoute from "./components/ProtectedRoute";
import Skills from "./pages/Skills";
import AdminDashboard from "./pages/AdminDashboard";
import Signup from "./pages/Signup";
import AdminAddJob from "./pages/AdminAddJob";
import StudentJobList from "./pages/StudentJobList";
import AdminApplicants from "./pages/AdminApplicants";

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
        
        <Route
          path="/profile"
          element={
            <ProtectedRoute>
              <StudentProfile />
            </ProtectedRoute>
          }
        />

        <Route
          path="/skills"
          element={
            <ProtectedRoute>
              <Skills />
            </ProtectedRoute>
          }
        />

        <Route path="/student/jobs" element={<StudentJobList />} />

        {/* Admin Routes */}
        <Route
          path="/admin"
          element={
            <ProtectedRoute>
              <AdminDashboard />
            </ProtectedRoute>
          }
        />
        
        <Route
          path="/admin/add-job"
          element={
            <ProtectedRoute>
              <AdminAddJob />
            </ProtectedRoute>
          }
        />
        
        <Route
          path="/admin/applicants"
          element={
            <ProtectedRoute>
              <AdminApplicants />
            </ProtectedRoute>
          }
        />
      </Routes>
    </BrowserRouter>
  );
}

export default App;