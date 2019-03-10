package eci.ieti.taskplannerAPI.Model;

import java.util.Date;

public class Task {
    private Date deuDate;
    private User responsible;
    private String status;
    private String description;
    public static  String READY="Ready";
    public static  String IN_PROGRESS="In Progress";
    public static  String DONE="Done";

    public Task(Date deuDate, User responsible, String status, String description) {
        this.deuDate = deuDate;
        this.responsible = responsible;
        this.status = status;
        this.description = description;
    }
}
