package Skill_Hub.model;

public class Request {

    private int requestId;
    private Learner learner;
    private Mentor mentor;
    private Skill skill;
    private String status;

    public Request(int requestId,
                   Learner learner,
                   Mentor mentor,
                   Skill skill) {

        this.requestId = requestId;
        this.learner = learner;
        this.mentor = mentor;
        this.skill = skill;
        this.status = "PENDING";
    }

    public void approve() {
        status = "APPROVED";
    }

    public void reject() {
        status = "REJECTED";
    }

    public String getStatus() {
        return status;
    }
}