package database;

import model.Skill;
import java.sql.*;
import java.util.ArrayList;

public class SkillDAO {

    public void insertSkill(Skill skill, String mentorName) {
        // Updated to save the mentor's name along with the skill
        String sql = "INSERT INTO skills(id, name, description, mentor_name) VALUES(?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, skill.getSkillId());
            ps.setString(2, skill.getSkillName());
            ps.setString(3, skill.getSkillDes()); // Matches your model getter
            ps.setString(4, mentorName);

            ps.executeUpdate();
            System.out.println("Success: Skill added to your profile!");

        } catch (Exception e) {
            System.out.println("DAO Error saving skill: " + e.getMessage());
        }
    }

    public ArrayList<Skill> getAllSkills() {
        ArrayList<Skill> skillList = new ArrayList<>();
        String sql = "SELECT * FROM skills";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                
                // Read the mentor name from the DB column
                String mentor = rs.getString("mentor_name");
                if (mentor == null) mentor = "System Assignment";

                Skill skill = new Skill(id, name, description);
                
                // --- FIXED: Linked the database string directly into your Java Object model field ---
                skill.setMentorName(mentor); 
                
                skillList.add(skill);
            }

        } catch (Exception e) {
            System.out.println("DAO Error reading skills: " + e.getMessage());
        }
        return skillList;
    }
}