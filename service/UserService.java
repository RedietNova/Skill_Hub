package service;

import model.*;
import java.util.ArrayList;

public class UserService {

    private ArrayList<User> users;

    public UserService() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(int id) {

        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getId() == id) {
                users.remove(i);
                break;
            }
        }
    }

    public User searchUser(int id) {

        for (User user : users) {

            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    public void displayAllUsers() {

        for (User user : users) {
            user.displayProfile();
            System.out.println("----------------");
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}