package database;

import model.Session;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class SessionDAO {

    public void insertSession(Session session) {
        String sql = "INSERT INTO sessions(mentor_id, learner_id, skill, status) VALUES(?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Getting IDs from the embedded User objects
            ps.setInt(1, session.getMentor().getId());
            ps.setInt(2, session.getLearner().getId());
            ps.setString(3, session.getSkill().getSkillName());
            ps.setString(4, session.getStatus()); // e.g., "Scheduled"

            ps.executeUpdate();
            System.out.println("Session successfully scheduled in the database!");

        } catch (Exception e) {
            System.out.println("DAO Error creating session: " + e.getMessage());
        }
    }
}