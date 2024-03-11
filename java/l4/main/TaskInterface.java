package l4.main;

public interface TaskInterface {
        void displayDetails();
        void addComment(String comment);
        void changeStatus(String newStatus);
        void setPriority(int priority);
        void assignUser(User user);
}
