package database;

import java.sql.*;

public class SessionDAO {

    public  void insertSession(int mentorId,
                              int learnerId,
                              String skill,
                            String status ) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO sessions(mentor_id,learner_id,skill,status) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, mentorId);
            ps.setInt(2, learnerId);
            ps.setString(3, skill);
            ps.setString(4, status);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
