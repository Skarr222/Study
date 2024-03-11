package l4.main;

import java.util.ArrayList;
import java.util.List;

public class TaskManagementSystem {
    private List<TaskInterface> tasks;

    public TaskManagementSystem() {
        this.tasks = new ArrayList<>();
    }
    public void addTask(TaskInterface task) {
        tasks.add(task);
    }

    public void displayTaskDetails(TaskInterface task) {
        task.displayDetails();
    }
    public void changeTaskStatus(TaskInterface task, String newStatus) {
        task.changeStatus(newStatus);
    }

    public void addCommentToTask(TaskInterface task, String comment) {
        task.addComment(comment);
    }
    public void assignUserToTask(TaskInterface task, User user) {
        if (task instanceof Task) {
            ((Task) task).assignUser(user);
        }
    }
    public void summarizeProgress() {
        int completedTasks = 0;
        int totalTasks = tasks.size();
        for (TaskInterface task : tasks) {
            if (task instanceof Task) {
                if (((Task) task).getStatus().equals("zakończone")){
                    completedTasks++;
                }
            }
        }
        System.out.println("Postęp projektu: " + completedTasks + " z " + totalTasks + " zadań zostało pomyślnie zakończonych.");
    }
}
