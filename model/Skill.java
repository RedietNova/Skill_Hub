package Skill_Hub.model;

public class Skill {
    private int skillId;
    private String skillName;
    private String skillDes;
    private String mentorName; // Make sure this field exists!

    // Constructor for creating a skill (without mentor assigned initially)
    public Skill(int skillId, String skillName, String skillDes) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.skillDes = skillDes;
    }

    // Full constructor (used when database loads a skill with its mentor)
    public Skill(int skillId, String skillName, String skillDes, String mentorName) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.skillDes = skillDes;
        this.mentorName = mentorName;
    }

    // --- GETTERS ---
    public int getSkillId() { 
        return skillId; 
    }

    public String getSkillName() { 
        return skillName; 
    }

    // Matches matchedSkill.getSkillDes() in Main.java
    public String getSkillDes() { 
        return skillDes; 
    }

    // FIX: This solves the "getMentorName is undefined" error!
    public String getMentorName() { 
        return mentorName; 
    }

    // --- SETTERS (Optional but good to have) ---
    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }
}