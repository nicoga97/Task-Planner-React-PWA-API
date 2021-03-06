package eci.ieti.taskplannerAPI.RestControllers;

import eci.ieti.taskplannerAPI.Model.Task;
import eci.ieti.taskplannerAPI.Model.User;
import eci.ieti.taskplannerAPI.Services.TaskService;
import eci.ieti.taskplannerAPI.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired

    private TaskService taskService;
    @Autowired

    private UserService userService;


    @GetMapping("/tasks")
    public ResponseEntity<?> getTasksHandler() {
        try {

            return new ResponseEntity<>(taskService.geTasksList(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("tasks/{id}")
    public ResponseEntity<?> getTaskByIdHandler(@PathVariable("id") String id) {
        try {

            return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("tasks/byUser/{email}")
    public ResponseEntity<?> getTasksByUserIdHandler(@PathVariable("email") String email) {
        try {

            return new ResponseEntity<>(taskService.getTasksByUserEmail(email), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("tasks/assign/{id}")
    public ResponseEntity<?> assignResponsibleToTaskHandler(@PathVariable("id") String id,@RequestBody User user) {
        try {

            return new ResponseEntity<>(taskService.assignTaskToUser(id, user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("tasks/update")
    public ResponseEntity<?> updateTaskHandler(@RequestBody Task task) {
        try {

            return new ResponseEntity<>(taskService.updateTask(task), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tasks")
    public ResponseEntity<?> createTaskHandler(@RequestBody Task task) {
        try {
            return new ResponseEntity<>(taskService.createTask(task), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("tasks/{id}")
    public ResponseEntity<?> deleteTaskHandler(@PathVariable  String id) {
        try {
            taskService.removeTask(id);
            return new ResponseEntity<> ( HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsersHandler() {
        try {

            return new ResponseEntity<>(userService.getUsersList(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/users")
    public ResponseEntity<?> updateUserHandler(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.updateUser(user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("users/{email}")
    public ResponseEntity<?> deleteUserHandler(@PathVariable String email) {
        try {
            userService.removeUser(email);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
