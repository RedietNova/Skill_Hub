package service;

import database.SessionDAO;
import model.Session;

public class SessionService {

    private final SessionDAO sessionDAO = new SessionDAO();

    public void createSession(Session session) {
        // Business rule: validation check
        if (session.getMentor() == null || session.getLearner() == null || session.getSkill() == null) {
            System.out.println("Error: Session must contain a valid Mentor, Learner, and Skill.");
            return;
        }
        
        sessionDAO.insertSession(session);
    }
}