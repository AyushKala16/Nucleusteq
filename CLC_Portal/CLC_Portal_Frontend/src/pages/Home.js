import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";

const Home = () => {
  const { user } = useAuth();
  const navigate = useNavigate();

  useEffect(() => {
    if (!user) {
        console.log(user);
      navigate("/login");
    } else {
      const role = user.data.role.toLowerCase();
      if (role === "student") navigate("/student");
      else if (role === "officer") navigate("/officer");
      else if (role === "admin") navigate("/admin");
    }
  }, [user, navigate]);

  return <div>Redirecting...</div>; 
};

export default Home;
