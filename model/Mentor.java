package Skill_Hub.model;

import java.util.ArrayList;

public class Mentor extends User {

    protected ArrayList<Skill> skills;

    public Mentor() {
        skills = new ArrayList<>();
    }

    public Mentor(String name, String email, String password, String role) {
        super( name, email, password, role);
        skills = new ArrayList<>();

    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    @Override
    public void displayProfile() {
        System.out.println("Mentor: " + name);
    }
}