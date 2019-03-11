package eci.ieti.taskplannerAPI.RestControllers;

import eci.ieti.taskplannerAPI.Model.Task;
import eci.ieti.taskplannerAPI.Model.User;
import eci.ieti.taskplannerAPI.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> getTasksHandler() {
        try {

            return new ResponseEntity<>(service.geTasksList(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskByIdHandler(@PathVariable("id") String id) {
        try {

            return new ResponseEntity<>(service.getTaskById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byUser/{userId}")
    public ResponseEntity<?> getTasksByUserIdHandler(@PathVariable("userId") String userId) {
        try {

            return new ResponseEntity<>(service.getTasksByUserId(userId), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/assignTask/{id}")
    public ResponseEntity<?> assignResponsibleToTaskHandler(@PathVariable("id") String id,@RequestBody User user) {
        try {

            return new ResponseEntity<>(service.assignTaskToUser(id,user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/assignTask")
    public ResponseEntity<?> updateTaskHandler(@RequestBody Task task) {
        try {

            return new ResponseEntity<>(service.updateTask(task), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<?> createTaskHandler(@RequestBody Task task) {
        try {
            return new ResponseEntity<>(service.createTask(task), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTaskHandler(@PathVariable  String id) {
        try {
            service.removeTask(id);
            return new ResponseEntity<> ( HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
