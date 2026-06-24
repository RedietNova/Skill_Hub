package Skill_Hub.model;

public class Review {
    private int id;
    private String mentorName;
    private String learnerName;
    private int rating;
    private String comments;

    public Review(int id, String mentorName, String learnerName, int rating, String comments) {
        this.id = id;
        this.mentorName = mentorName;
        this.learnerName = learnerName;
        this.rating = rating;
        this.comments = comments;
    }

    // Getters
    public int getId() { return id; }
    public String getMentorName() { return mentorName; }
    public String getLearnerName() { return learnerName; }
    public int getRating() { return rating; }
    
    // Plural version used by Main.java
    public String getComments() { return comments; }
    
    // --- ADDED THIS SINGULAR VERSION TO FIX THE ERROR IN REVIEWSERVICE ---
    public String getComment() { return  comments; } 
}