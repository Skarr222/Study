package l4.main;

public class User {
    private String name;
    private String role;

    public User(String name,  String role) {
        this.name = name;
        this.role = role;
    }

    public String displayDetails() {
        return "Nazwa: " + name + " Rola: " + role;
    }

}
