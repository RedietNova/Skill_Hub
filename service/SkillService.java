package Skill_Hub.service;
import java.util.ArrayList;
import database.SkillDAO;
import model.Skill;
import exception.InvalidSkillException;

public class SkillService {

    private final SkillDAO skillDAO = new SkillDAO();

    public void addSkill(Skill skill, String mentorName) throws InvalidSkillException {
        // Business Rule Validation
        if (skill.getSkillName() == null || skill.getSkillName().trim().isEmpty()) {
            throw new InvalidSkillException("Skill name cannot be empty!");
        }
        
        if (skill.getSkillDes() == null || skill.getSkillDes().trim().isEmpty()) {
            throw new InvalidSkillException("Skill description cannot be empty!");
        }

        // Pass the real mentorName variable down to the database layer
        skillDAO.insertSkill(skill, mentorName); 
    }

    public void displayAllSkills() {
        ArrayList<Skill> skills = skillDAO.getAllSkills();

        if (skills.isEmpty()) {
            System.out.println("No skills are currently available in the system.");
            return;
        }

        System.out.println("\n===== AVAILABLE SKILLS =====");
        for (Skill skill : skills) {
            // Check if the mentor name exists; if it's null, give it a fallback string
            String teacher = (skill.getMentorName() != null) ? skill.getMentorName() : "System Assignment";

            // --- FIXED: Added skill.getMentorName() to the print statement ---
            System.out.println("ID: " + skill.getSkillId() + 
                               " | Name: " + skill.getSkillName() + 
                               " | Mentor: " + teacher + 
                               " | Description: " + skill.getSkillDes());
        }
        System.out.println("=============================");
    }
}