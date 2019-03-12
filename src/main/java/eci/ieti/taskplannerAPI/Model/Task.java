package eci.ieti.taskplannerAPI.Model;

import java.time.LocalDate;

public class Task {
    private String id;
    private LocalDate dueDate;
    private User responsible;
    private String status;
    private String description;
    public static String READY = "Ready";
    public static String IN_PROGRESS = "In Progress";
    public static String DONE = "Done";

    public Task(LocalDate dueDate, User responsible, String status, String description) {
        this.dueDate = dueDate;
        this.responsible = responsible;
        this.status = status;
        this.description = description;
    }

    public Task(String id, LocalDate dueDate, User responsible, String status, String description) {
        this.id = id;
        this.dueDate = dueDate;
        this.responsible = responsible;
        this.status = status;
        this.description = description;
    }

    public Task(LocalDate dueDate, String status, String description) {
        this.dueDate = dueDate;
        this.status = status;
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public User getResponsible() {
        return responsible;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public void assignResponsible(User responsible) {
        this.responsible=responsible;
    }
}
