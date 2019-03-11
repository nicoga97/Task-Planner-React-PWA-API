package eci.ieti.taskplannerAPI.Services;

import eci.ieti.taskplannerAPI.Model.Task;
import eci.ieti.taskplannerAPI.Model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceStub implements TaskService {
    private  List<Task> taskList;

    public TaskServiceStub() {

        this.taskList = new ArrayList<>();
        taskList.add(new Task("1", LocalDate.of(2019,1,15),new User("Nicolas Garcia","nicoga97@gmail.com","1"),Task.IN_PROGRESS,"Make backEnd"));
        taskList.add(new Task("2", LocalDate.of(2019,2,5),new User("Andres Perez","andres@gmail.com","2"),Task.DONE,"Make FrontEnd"));
        taskList.add(new Task("3", LocalDate.of(2019,2,20),new User("Andres Perez","andres@gmail.com","2"),Task.IN_PROGRESS,"Design an API rest service"));
        taskList.add(new Task("4", LocalDate.of(2019,1,21),new User("Camilo Fajardo","camilo@gmail.com","3"),Task.READY,"Make sprint planning"));
    }

    @Override
    public Task createTask(Task task) {
        task.setId(Integer.toString(taskList.size()+1));
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
    public List<Task> getTasksByUserId(String userId) {
        List<Task> userTasks=new ArrayList<>();
        for(Task task:taskList){
            if(task.getResponsible().getId().equals(userId)){
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
