package database;

import model.Review;
import java.sql.*;
import java.util.ArrayList;

public class ReviewDAO {

    public ArrayList<Review> getReviewForMentor(String mentorName) {
        ArrayList<Review> list = new ArrayList<>();
        // 1. Double check that 'comments' is plural here
        String sql = "SELECT * FROM reviews WHERE mentor_name = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, mentorName);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Review(
                        rs.getInt("id"),
                        rs.getString("mentor_name"),
                        rs.getString("learner_name"),
                        rs.getInt("rating"),
                        rs.getString("comments") // --- MATCHES DATABASE NOW ---
                    ));
                }
            }
        } catch (Exception e) {
            System.out.println("Database Error fetching reviews: " + e.getMessage());
        }
        return list;
    }

    public double getAverageRatingForMentor(String mentorName) {
        String sql = "SELECT AVG(rating) as avg_rating FROM reviews WHERE mentor_name = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, mentorName);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    double avg = rs.getDouble("avg_rating");
                    return avg > 0 ? avg : 0.0; 
                }
            }
        } catch (Exception e) {
            System.out.println("Error calculating average rating: " + e.getMessage());
        }
        return 0.0;
    }

    public void insertReview(Review review) {
        // 2. Double check that 'comments' is plural here too
        String sql = "INSERT INTO reviews(mentor_name, learner_name, rating, comments) VALUES(?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, review.getMentorName());
            ps.setString(2, review.getLearnerName());
            ps.setInt(3, review.getRating());
            ps.setString(4, review.getComments()); 

            ps.executeUpdate();
            System.out.println("Success: Your review has been saved!");

        } catch (Exception e) {
            System.out.println("Database Error saving review: " + e.getMessage());
        }
    }
}