package auth;

import model.User;

public class AuthManager {

    private User currentUser;

    public void login(User user) {

        currentUser = user;

        System.out.println(
                "Welcome "
                + user.getName()
        );
    }

    public void logout() {

        if (currentUser != null) {

            System.out.println(
                    currentUser.getName()
                    + " logged out."
            );

            currentUser = null;
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }
}