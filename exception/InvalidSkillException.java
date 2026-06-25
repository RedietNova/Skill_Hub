package Skill_Hub.exception;

// Checked exception extending Exception to enforce explicit compile-time handling
public class InvalidSkillException extends Exception {
    public InvalidSkillException(String message) {
        super(message);
    }
}
