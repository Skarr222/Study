package l4.main;


public abstract class Task implements TaskInterface {
    private String title;
    private String description;
    private int priority;
    private User assignedUser;
    private String status;

    public Task(String title, String description, int priority, String status) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
    public void addComment(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public  String getStatus() {
        return status;
    }

    public void changeStatus(String status) {
        this.status = status;
    }
    public void assignUser(User user) {
        this.assignedUser = user;
    }
    @Override
    public void displayDetails() {
        System.out.println("Tytuł: " + getTitle());
        System.out.println("Opis: " + getDescription());
        System.out.println("Priorytet: " + getPriority());
        System.out.println("Status: " + getStatus());
        if (assignedUser != null) {
            System.out.println("Przypisany User: " + assignedUser.displayDetails());
        }
    }
}
