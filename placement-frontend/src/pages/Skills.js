import { useEffect, useState } from "react";
import { getSkills, addSkill } from "../api/skillApi";
import { logout } from "../utils/auth";

function Skills() {
  const [skills, setSkills] = useState([]);
  const [name, setName] = useState("");
  const [level, setLevel] = useState("");

  const loadSkills = () => {
    getSkills()
      .then(res => setSkills(res.data))
      .catch(() => alert("Failed to load skills"));
  };

  useEffect(() => {
    loadSkills();
  }, []);

  const handleAddSkill = async () => {
    if (!name || !level) {
      alert("Enter skill and level");
      return;
    }

    try {
      await addSkill(name, level);
      setName("");
      setLevel("");
      loadSkills(); // refresh list
    } catch {
      alert("Error adding skill");
    }
  };

  return (
    <div>
      <h2>My Skills</h2>

      <input
        placeholder="Skill name"
        value={name}
        onChange={e => setName(e.target.value)}
      />

      <select value={level} onChange={e => setLevel(e.target.value)}>
        <option value="">Select level</option>
        <option value="BEGINNER">BEGINNER</option>
        <option value="INTERMEDIATE">INTERMEDIATE</option>
        <option value="ADVANCED">ADVANCED</option>
      </select>

      <button onClick={handleAddSkill}>Add Skill</button>

      <hr />

      <ul>
        {skills.map((skill, index) => (
          <li key={index}>
            {skill.name} — {skill.level}
          </li>
        ))}
      </ul>

      <br />
      <button onClick={logout}>Logout</button>
    </div>
  );
}

export default Skills;
