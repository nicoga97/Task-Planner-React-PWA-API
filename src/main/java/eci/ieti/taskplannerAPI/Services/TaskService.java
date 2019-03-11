package eci.ieti.taskplannerAPI.Services;

import eci.ieti.taskplannerAPI.Model.Task;
import eci.ieti.taskplannerAPI.Model.User;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);

    List<Task> geTasksList();

    Task getTaskById(String id) throws TaskPlannerServiceException;

    List<Task> getTasksByUserId(String userId);

    Task assignTaskToUser(String taskId, User user) throws TaskPlannerServiceException;

    void removeTask(String taskId);

    Task updateTask(Task task) throws TaskPlannerServiceException;
}