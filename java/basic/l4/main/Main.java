package l4.main;

public class Main {
    public static void main(String[] args) {
        UserStoryTask userStoryTask = new UserStoryTask("User Story Task", "To jest user story task", 1, "do zrobienia");
        BugTask bugTask = new BugTask("Bug Task", "To jest bug task", 2, "w trakcie");
        EpikTask epikTask = new EpikTask("Epik Task", "To jest epik task", 3, "zakończone");

        TaskManagementSystem taskManagementSystem = new TaskManagementSystem();
        taskManagementSystem.addTask(userStoryTask);
        taskManagementSystem.addTask(bugTask);
        taskManagementSystem.addTask(epikTask);
        System.out.println("=====================================");
        System.out.println("Dodanie zadań");
        System.out.println("=====================================");
        taskManagementSystem.displayTaskDetails(userStoryTask);
        System.out.println("=====================================");
        taskManagementSystem.displayTaskDetails(bugTask);
        System.out.println("=====================================");
        taskManagementSystem.displayTaskDetails(epikTask);
        System.out.println("=====================================");

        taskManagementSystem.summarizeProgress();
        System.out.println(" ");

        System.out.println("=====================================");
        System.out.println("Zmiana statusu zadania");
        System.out.println("=====================================");
        taskManagementSystem.changeTaskStatus(userStoryTask, "w trakcie");
        taskManagementSystem.displayTaskDetails(userStoryTask);
        System.out.println("=====================================");
        taskManagementSystem.changeTaskStatus(bugTask, "zakończone");
        taskManagementSystem.displayTaskDetails(bugTask);
        System.out.println("=====================================");
        taskManagementSystem.displayTaskDetails(epikTask);
        System.out.println("=====================================");

        taskManagementSystem.summarizeProgress();
        System.out.println(" ");

        System.out.println("=====================================");
        System.out.println("Zmiana komentarza zadania");
        System.out.println("=====================================");
        taskManagementSystem.addCommentToTask(userStoryTask, "Komentarz 1");
        taskManagementSystem.displayTaskDetails(userStoryTask);
        System.out.println("=====================================");
        taskManagementSystem.addCommentToTask(bugTask, "Komentarz 2");
        taskManagementSystem.displayTaskDetails(bugTask);
        System.out.println("=====================================");
        taskManagementSystem.addCommentToTask(epikTask, "Komentarz 3");
        taskManagementSystem.displayTaskDetails(epikTask);
        System.out.println("=====================================");
        System.out.println(" ");

        System.out.println("=====================================");
        System.out.println("Zmiana priorytetu zadania");
        System.out.println("=====================================");
        userStoryTask.setPriority(3);
        bugTask.setPriority(1);
        epikTask.setPriority(2);
        taskManagementSystem.displayTaskDetails(userStoryTask);
        System.out.println("=====================================");
        taskManagementSystem.displayTaskDetails(bugTask);
        System.out.println("=====================================");
        taskManagementSystem.displayTaskDetails(epikTask);
        System.out.println("=====================================");
        System.out.println(" ");

        User user = new User("Jan", "Developer");
        User user2 = new User("Adam", "Tester");

        System.out.println("=====================================");
        System.out.println("Przypisanie użytkownika zadania");
        System.out.println("=====================================");
        taskManagementSystem.assignUserToTask(userStoryTask, user);
        taskManagementSystem.displayTaskDetails(userStoryTask);
        System.out.println("=====================================");
        taskManagementSystem.assignUserToTask(bugTask, user2);
        taskManagementSystem.displayTaskDetails(bugTask);
        System.out.println("=====================================");

    }
}
