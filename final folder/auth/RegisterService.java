package auth;

import database.UserDAO;
import model.*;

public class RegisterService {

    public static Mentor registerMentor( String name,String email,String password) {
                UserDAO userDAO = new UserDAO();

                User user = new Mentor( name, email, password, "Mentor");

                userDAO.insertUser(user);

                return new Mentor( name, email, password, "Mentor");
    }

    public static Learner registerLearner(  String name,String email, String password) {
                
                UserDAO userDAO = new UserDAO();

                User user = new Learner( name, email, password, "Learner");

                userDAO.insertUser(user);

                return new Learner( name, email, password, "Learner");
       
    }
}