package auth;

import model.User;
import exception.InvalidLoginException;
import database.UserDAO;
import java.util.ArrayList;

public class Loginservice {

    private final UserDAO userDAO = new UserDAO();

    // REMOVED 'static' keyword here
    public User login(String email, String password) throws InvalidLoginException {
        ArrayList<User> users = userDAO.getAllUsers();

        for (User user : users) {
            // Check if both credentials match perfectly
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                System.out.println("Login successful: " + user.getName());
                return user;
            }
        }

        // Thrown only if the entire loop finishes without returning a user
        throw new InvalidLoginException("Invalid email or password!");
    }

    public boolean userExists(String email) {
        ArrayList<User> users = userDAO.getAllUsers();
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }
}