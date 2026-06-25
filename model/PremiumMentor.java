package Skill_Hub.model;

public class PremiumMentor extends Mentor {

    private String badge;

    public PremiumMentor(int id,
                         String name,
                         String email,
                         String password,
                         String badge) {

        super();
        this.badge = badge;
    }

    @Override
    public void displayProfile() {
        super.displayProfile();
        System.out.println("Badge: " + badge);
    }
}