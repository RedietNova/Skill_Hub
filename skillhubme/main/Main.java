package main;

import java.util.ArrayList;
import java.util.Scanner;
import model.*;
import service.*;
import auth.*;
import exception.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // SERVICE LAYER CONTEXTS
        UserService userService = new UserService();
        SkillService skillService = new SkillService();
        // Commented out below to completely remove the "local variable is not used" warnings:
        // SessionService sessionService = new SessionService(); 
        // ReviewService reviewService = new ReviewService();

        // AUTHENTICATION MANAGEMENT
        AuthManager auth = new AuthManager();
        Loginservice loginService = new Loginservice();

        while (true) {

            System.out.println("\n===== SKILL HUB SYSTEM =====");
            System.out.println("1. Register as a Mentor");
            System.out.println("2. Register as a Learner");
            System.out.println("3. Log In");
            System.out.println("4. Add a Skill (Mentors Only)");
            System.out.println("5. View All Available Skills");
            System.out.println("6. Search and Book a Course Session");
            System.out.println("7. Show All Registered Users");
            System.out.println("8. View a Mentor's Reviews & Ratings");
            System.out.println("9. Rate a Mentor (Learners Only)");
            System.out.println("10. Log Out");
            System.out.println("0. Exit Application");
            System.out.print("Please choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Clear scanner buffer

            try {
                switch (choice) {

                    // 1. REGISTER MENTOR
                    case 1:
                        System.out.println("\n--- Mentor Registration ---");
                        System.out.print("Enter Name: ");
                        String mname = sc.nextLine();
                        System.out.print("Enter Email Address: ");
                        String memail = sc.nextLine();
                        System.out.print("Enter Password: ");
                        String mpass = sc.nextLine();

                        RegisterService.registerMentor(mname, memail, mpass);
                        System.out.println("Success: Mentor account created!");
                        break;

                    // 2. REGISTER LEARNER
                    case 2:
                        System.out.println("\n--- Learner Registration ---");
                        System.out.print("Enter Name: ");
                        String lname = sc.nextLine();
                        System.out.print("Enter Email Address: ");
                        String lemail = sc.nextLine();
                        System.out.print("Enter Password: ");
                        String lpass = sc.nextLine();

                        RegisterService.registerLearner(lname, lemail, lpass);
                        System.out.println("Success: Learner account created!");
                        break;

                    // 3. LOGIN INTERFACE
                    case 3:
                        System.out.println("\n--- User Login ---");
                        System.out.print("Email Address: ");
                        String email = sc.nextLine().trim();
                        System.out.print("Password: ");
                        String pass = sc.nextLine().trim();

                        try {
                            User user = loginService.login(email, pass);
                            auth.login(user); 
                            System.out.println("Welcome back, " + user.getName() + "!");
                        } catch (InvalidLoginException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    // 4. ADD SKILL MODULE
                    case 4:
                        if (!auth.isLoggedIn()) {
                            System.out.println("Error: You must log in first.");
                            break;
                        }

                        if (!(auth.getCurrentUser() instanceof Mentor)) {
                            System.out.println("Access Denied: Only Mentors can add new skills.");
                            break;
                        }

                        Mentor currentMentor = (Mentor) auth.getCurrentUser();
                        System.out.println("\n--- Add a New Skill (Logged in as: " + currentMentor.getName() + ") ---");

                        System.out.print("Enter a Unique Skill ID (Number): ");
                        int sid = sc.nextInt();
                        sc.nextLine(); // Clear buffer
                        System.out.print("Enter Skill Name: ");
                        String sname = sc.nextLine();
                        System.out.print("Enter Skill Description: ");
                        String desc = sc.nextLine();

                        Skill skill = new Skill(sid, sname, desc);
                        
                        // Pass the logged-in mentor's real name directly into the service layer
                        skillService.addSkill(skill, currentMentor.getName());
                        System.out.println("Success: Skill added to your profile!");
                        break;

                    // 5. VIEW SKILLS
                    case 5:
                        System.out.println("\nLoading available skills catalog...");
                        skillService.displayAllSkills();
                        break;

                    // 6. CREATE LEARNING SESSION (SEARCH BY COURSE WORKFLOW)
                    case 6:
                        if (!auth.isLoggedIn()) {
                            System.out.println("Error: You must log in first.");
                            break;
                        }

                        User sessionCreator = auth.getCurrentUser();
                        if (!(sessionCreator instanceof Learner)) {
                            System.out.println("Notice: Sessions are typically requested by Learners looking for courses.");
                            break;
                        }

                        System.out.println("\n--- Search & Book a Course ---");
                        System.out.print("What subject or skill do you want to learn?: ");
                        String desiredSkill = sc.nextLine().trim();

                        // 1. Search the database for any matching skills
                        ArrayList<Skill> matches = new ArrayList<>();
                        for (Skill s : new database.SkillDAO().getAllSkills()) {
                            if (s.getSkillName().equalsIgnoreCase(desiredSkill)) {
                                matches.add(s);
                            }
                        }

                        if (matches.isEmpty()) {
                            System.out.println("Sorry, no mentors are teaching '" + desiredSkill + "' right now.");
                            break;
                        }

                        // 2. Display available options with dynamic database feedback ratings
                        System.out.println("\nFound the following options for '" + desiredSkill + "':");
                        System.out.println("------------------------------------------------------------------");
                        database.ReviewDAO rCalculationDao = new database.ReviewDAO();
                        
                        for (int i = 0; i < matches.size(); i++) {
                            Skill matchedSkill = matches.get(i);
                            String teacher = matchedSkill.getMentorName();
                            if (teacher == null) teacher = "Unknown Mentor";
                            
                            double avg = rCalculationDao.getAverageRatingForMentor(teacher);
                            String stars = (avg == 0.0) ? "No reviews yet" : String.format("%.1f ★", avg);

                            System.out.println("[" + (i + 1) + "] Mentor Name: " + teacher + 
                                               " | Rating: " + stars + 
                                               " | Description: " + matchedSkill.getSkillDes());
                        }
                        System.out.println("------------------------------------------------------------------");

                        System.out.print("Select an option number to book: ");
                        int choiceIndex = sc.nextInt() - 1;
                        sc.nextLine(); // Clear buffer

                        if (choiceIndex < 0 || choiceIndex >= matches.size()) {
                            System.out.println("Invalid selection selection canceled.");
                            break;
                        }

                        Skill selectedSkill = matches.get(choiceIndex);
                        String selectedTeacherName = selectedSkill.getMentorName();

                        // 3. Find the exact matching selected Mentor object from the DB
                        User selectedMentor = null;
                        for (User u : new database.UserDAO().getAllUsers()) {
                            if (u.getName().equalsIgnoreCase(selectedTeacherName) && u instanceof Mentor) {
                                selectedMentor = u;
                                break;
                            }
                        }

                        if (selectedMentor == null) {
                            System.out.println("Error: The selected mentor is no longer active.");
                            break;
                        }

                        // 4. Create session with status "Pending" so the Mentor can see it
                        Session proposedSession = new Session(0, (Mentor) selectedMentor, (Learner) sessionCreator, selectedSkill, "Pending");
                        new SessionService().createSession(proposedSession);
                        System.out.println("Success: Course requested! A waiting connection has been sent to " + selectedTeacherName + ".");
                        break;
                        
                    // 7. DISPLAY REGISTERED SYSTEM USERS
                    case 7:
                        System.out.println("\nFetching registered global profile list...");
                        userService.displayAllUsers();
                        break;

                    // 8. VIEW A MENTOR'S REVIEWS & RATINGS
                    case 8:
                        System.out.println("\n--- View Mentor Feedback Profile ---");
                        System.out.print("Enter the name of the Mentor to lookup: ");
                        String searchMentor = sc.nextLine().trim();

                        database.ReviewDAO rDao = new database.ReviewDAO();
                        ArrayList<Review> mentorReviews = rDao.getReviewForMentor(searchMentor);

                        if (mentorReviews.isEmpty()) {
                            System.out.println("Notice: No one has left a review for '" + searchMentor + "' yet.");
                            break;
                        }

                        double avgScore = rDao.getAverageRatingForMentor(searchMentor);

                        System.out.println("\n=========================================================");
                        System.out.println(" FEEDBACK PROFILE FOR: " + searchMentor.toUpperCase());
                        System.out.println(" Overall Rating: " + String.format("%.1f", avgScore) + " / 5.0 ★");
                        System.out.println("=========================================================");

                        for (Review r : mentorReviews) {
                            System.out.println("• [" + r.getRating() + " / 5 ★] Left by: " + r.getLearnerName());
                            System.out.println("  Comment: \"" + r.getComments() + "\"");
                            System.out.println("---------------------------------------------------------");
                        }
                        break;

                    // 9. WRITE A MENTOR REVIEW & RATING (LEARNERS ONLY)
                    case 9:
                        if (!auth.isLoggedIn()) {
                            System.out.println("Error: You must log in first.");
                            break;
                        }

                        User reviewer = auth.getCurrentUser();
                        if (!(reviewer instanceof Learner)) {
                            System.out.println("Access Denied: Only Learners can write reviews for mentors.");
                            break;
                        }

                        System.out.println("\n--- Rate a Mentor ---");
                        System.out.print("Enter the name of the Mentor you want to rate: ");
                        String targetMentor = sc.nextLine().trim();

                        System.out.print("Enter your rating (1 to 5 stars): ");
                        int starRating = sc.nextInt();
                        sc.nextLine(); // Clear scanner buffer

                        if (starRating < 1 || starRating > 5) {
                            System.out.println("Error: Rating must be between 1 and 5.");
                            break;
                        }

                        System.out.print("Enter your feedback comments: ");
                        String feedback = sc.nextLine().trim();

                        Review newReview = new Review(0, targetMentor, reviewer.getName(), starRating, feedback);
                        new database.ReviewDAO().insertReview(newReview);
                        break;

                    // 10. LOGOUT
                    case 10:
                        if (!auth.isLoggedIn()) {
                            System.out.println("Notice: No active login session found.");
                        } else {
                            System.out.println("Goodbye, " + auth.getCurrentUser().getName() + "!");
                            auth.logout();
                            System.out.println("Success: You have been logged out safely.");
                        }
                        break;

                    // 0. EXIT
                    case 0:
                        System.out.println("Closing the application safely... Goodbye!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Selection out of range. Please pick an option from the menu.");
                }

            } catch (Exception e) {
                System.out.println("System Engine Error: " + e.getMessage());
            }
        }
    }
}
