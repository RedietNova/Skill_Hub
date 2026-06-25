package Skill_Hub.model;

import java.util.ArrayList;

public class Learner extends User {

    private ArrayList<Skill> learningSkills;

    public Learner() {
        learningSkills = new ArrayList<>();
    }

    public Learner( String name, String email, String password, String role) {
        super( name, email, password, role);
        learningSkills = new ArrayList<>();
    }

    public void requestSkill(Skill skill) {
        learningSkills.add(skill);
    }

    @Override
    public void displayProfile() {
        System.out.println("Learner: " + name);
    }
}