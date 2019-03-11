package eci.ieti.taskplannerAPI.Services;

public class TaskPlannerServiceException extends  Exception {

    public static String TASK_NOT_FOUND="The task does not exists";
    public static String USER_NOT_FOUND="The user does not exists";

    public TaskPlannerServiceException(String message) {
        super(message);
    }

    public TaskPlannerServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
