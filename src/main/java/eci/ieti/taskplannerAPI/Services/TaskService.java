package eci.ieti.taskplannerAPI.Services;

import eci.ieti.taskplannerAPI.Model.Task;
import eci.ieti.taskplannerAPI.Model.User;

import java.util.List;

public interface TaskService {
    List<Task> geTasksList();

    Task getTaskById(String id);

    List<Task> getTasksByUserId(String userId);

    Task assignTaskToUser(String taskId, User user);

    void removeTask(String taskId);

    Task updateTask(Task task);
}