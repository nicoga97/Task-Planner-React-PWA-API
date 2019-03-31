package eci.ieti.taskplannerAPI.Services.MongoDBImplementation;

import eci.ieti.taskplannerAPI.Model.Task;
import eci.ieti.taskplannerAPI.Model.User;
import eci.ieti.taskplannerAPI.Services.TaskPlannerServiceException;
import eci.ieti.taskplannerAPI.Services.TaskService;
import eci.ieti.taskplannerAPI.data.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class TaskServiceMongoDBImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    @Override
    public List<Task> geTasksList() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(String id) throws TaskPlannerServiceException {
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> getTasksByUserEmail(String email) {
        return taskRepository.findTasksByResponsibleEmail(email);
    }

    @Override
    public Task assignTaskToUser(String taskId, User user) throws TaskPlannerServiceException {
        Task task = taskRepository.findById(taskId).get();
        task.assignResponsible(user);
        taskRepository.save(task);
        return task;
    }

    @Override
    public void removeTask(String taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public Task updateTask(Task task) throws TaskPlannerServiceException {
        taskRepository.save(task);
        return task;
    }
}
