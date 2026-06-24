package Skill_Hub.model;

public abstract class User {

    protected int id;
    protected String name;
    protected String email;
    protected String password;
    protected String role;

    public static int userCount = 0;

    public User() {
        userCount++;
    }

    public User( String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        userCount++;
    }

    public abstract void displayProfile();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public final void setPassword(String password) {
        this.password = password;
    }
    public void setRole(String role){
        this.role = role;
    }
    public String getRole(){
        return role;
    }
}