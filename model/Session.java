package Skill_Hub.model;

public class Session {
    private int sessionId;
    private Mentor mentor;
    private Learner learner;
    private Skill skill;
    private String status;

    // Fixes "The constructor Session(...) is undefined"
    public Session(int sessionId, Mentor mentor, Learner learner, Skill skill, String status) {
        this.sessionId = sessionId;
        this.mentor = mentor;
        this.learner = learner;
        this.skill = skill;
        this.status = status;
    }

    // Fixes the "undefined" getters in SessionService
    public int getSessionId() { return sessionId; }
    public Mentor getMentor() { return mentor; }
    public Learner getLearner() { return learner; }
    public Skill getSkill() { return skill; }
    public String getStatus() { return status; }

    public void setSessionId(int sessionId) { this.sessionId = sessionId; }
    public void setMentor(Mentor mentor) { this.mentor = mentor; }
    public void setLearner(Learner learner) { this.learner = learner; }
    public void setSkill(Skill skill) { this.skill = skill; }
    public void setStatus(String status) { this.status = status; }
}
