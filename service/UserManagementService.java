package service;

import model.User;
import exception.InvalidLoginException;

import java.util.ArrayList;

public class UserManagementService {

    private ArrayList<User> users;

    public UserManagementService(ArrayList<User> users) {
        this.users = users;
    }

    public User login(String email,
                      String password)
            throws InvalidLoginException {

        for (User user : users) {

            if (user.getEmail().equals(email)
                    &&
                user.getPassword().equals(password)) {

                return user;
            }
        }

        throw new InvalidLoginException(
                "Invalid Email or Password");
    }
}