package eci.ieti.taskplannerAPI.RestControllers;

import eci.ieti.taskplannerAPI.Model.User;
import eci.ieti.taskplannerAPI.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> getUsersHandler() {
        try {

            return new ResponseEntity<>(service.getUsersList(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createUserHandler(@RequestBody User user) {
        try {

            return new ResponseEntity<>(service.createUser(user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateUserHandler(@RequestBody User user) {
        try {
            return new ResponseEntity<>(service.updateUser(user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserHandler(@PathVariable  String id) {
        try {
            service.removeUser(id);
            return new ResponseEntity<> ( HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
