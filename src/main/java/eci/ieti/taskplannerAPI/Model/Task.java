package eci.ieti.taskplannerAPI.Model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class Task {
    @Id
    protected String id;
    private LocalDate dueDate;
    private User responsible;
    private int priority;
    private String status;
    private String description;
    public static String READY = "Ready";
    public static String IN_PROGRESS = "In Progress";
    public static String DONE = "Done";

    public Task(String description, LocalDate dueDate, User responsible, String status) {
        this.dueDate = dueDate;
        this.responsible = responsible;
        this.status = status;
        this.description = description;
    }

    public Task(String description, int priority, LocalDate dueDate, User responsible, String status) {
        this.dueDate = dueDate;
        this.responsible = responsible;
        this.priority = priority;
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

    public Task() {
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

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", dueDate=" + dueDate +
                ", responsible=" + responsible +
                ", priority=" + priority +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
