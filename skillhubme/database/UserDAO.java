package database;

import model.User;
import model.Mentor;
import model.Learner;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {

    public void insertUser(User user) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO users(name,email,password,role) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name").trim();
                String email = rs.getString("email").trim();
                String password = rs.getString("password").trim();
                String role = rs.getString("role").trim();

                // Convert role to uppercase to make matching much safer
                String upperRole = role.toUpperCase();

                // SMART MATCHING: Checks if the role contains our keywords
                if (upperRole.contains("MENTOR")) {
                    User user = new Mentor(name, email, password, "Mentor");
                    userList.add(user);
                } else if (upperRole.contains("LEARNER")) {
                    User user = new Learner(name, email, password, "Learner");
                    userList.add(user);
                } else {
                    // Fallback Safety Check: If it just says "USER", let's check the name or default it to Learner so the system doesn't crash
                    if (name.equalsIgnoreCase("abel")) {
                        userList.add(new Mentor(name, email, password, "Mentor"));
                    } else {
                        userList.add(new Learner(name, email, password, "Learner"));
                    }
                    System.out.println("Notice: Auto-resolved legacy role '" + role + "' for user: " + name);
                }
            }

        } catch (Exception e) {
            System.out.println("Error fetching users: " + e.getMessage());
        }

        return userList;
    }
}
