package eci.ieti.taskplannerAPI.Services.InMemoryImplementation;

import eci.ieti.taskplannerAPI.Model.Task;
import eci.ieti.taskplannerAPI.Model.User;
import eci.ieti.taskplannerAPI.Services.TaskPlannerServiceException;
import eci.ieti.taskplannerAPI.Services.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service

public class TaskServiceImpl implements TaskService {
    private  List<Task> taskList;

    public TaskServiceImpl() {

        this.taskList = new ArrayList<>();
        taskList.add(new Task("1", LocalDate.of(2019, 1, 15), new User("nicoga97@gmail.com", "user1", "andres"), Task.IN_PROGRESS, "Make backEnd"));
        taskList.add(new Task("2", LocalDate.of(2019, 2, 5), new User("andres@gmail.com", "password", "Andres"), Task.DONE, "Make FrontEnd"));
        taskList.add(new Task("3", LocalDate.of(2019, 2, 20), new User("andres@gmail.com", "password", "Andres"), Task.IN_PROGRESS, "Design an API rest service"));
        taskList.add(new Task("4", LocalDate.of(2019, 1, 21), new User("camilo@gmail.com", "password", "Fajardo"), Task.READY, "Make sprint planning"));
    }

    @Override
    public Task createTask(Task task) {
        task.setId(Long.toString(taskList.size() + 1));
        taskList.add(task);
        return task;
    }

    @Override
    public List<Task> geTasksList() {
        return taskList;
    }

    @Override
    public Task getTaskById(String id) throws TaskPlannerServiceException {
        for(Task task:taskList){
            if(task.getId().equals(id)){
                return task;
            }
        }
        throw new TaskPlannerServiceException(TaskPlannerServiceException.TASK_NOT_FOUND);

    }

    @Override
    public List<Task> getTasksByUserEmail(String email) {
        List<Task> userTasks=new ArrayList<>();
        for(Task task:taskList){
            if (task.getResponsible().getEmail().equals(email)) {
               userTasks.add(task);
            }
        }
        return userTasks;
    }

    @Override
    public Task assignTaskToUser(String taskId, User user) throws TaskPlannerServiceException {
        for(Task task:taskList){
            if(task.getId().equals(taskId)){
                task.assignResponsible(user);
                return task;
            }
        }
        throw new TaskPlannerServiceException(TaskPlannerServiceException.TASK_NOT_FOUND);
    }

    @Override
    public void removeTask(String taskId) {
        for(Task task:taskList){
            if(task.getId().equals(taskId)){
                taskList.remove(task);
            }
        }
    }

    @Override
    public Task updateTask(Task task) throws TaskPlannerServiceException {
        for(Task task1:taskList){
            if(task1.getId().equals(task.getId())){
                task1=task;
                return task1;
            }
        }
        throw new TaskPlannerServiceException(TaskPlannerServiceException.TASK_NOT_FOUND);
    }
}
