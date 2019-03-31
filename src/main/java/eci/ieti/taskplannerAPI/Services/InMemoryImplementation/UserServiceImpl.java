package eci.ieti.taskplannerAPI.Services.InMemoryImplementation;

import eci.ieti.taskplannerAPI.Model.User;
import eci.ieti.taskplannerAPI.Services.TaskPlannerServiceException;
import eci.ieti.taskplannerAPI.Services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private List<User> users;

    public UserServiceImpl() {
        users=new ArrayList<>();
        users.add(new User("nicoga97@gmail.com", "password", "Nicolas"));
        users.add(new User("andres@gmail.com", "password", "Andres"));
        users.add(new User("camilo@gmail.com", "password", "Camilo"));
    }

    @Override
    public List<User> getUsersList() {
        return users;
    }

    @Override
    public User getUserByEmail(String email) throws TaskPlannerServiceException {
        for(User user:users){
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        throw new TaskPlannerServiceException(TaskPlannerServiceException.USER_NOT_FOUND);
    }

    @Override
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(User user) throws TaskPlannerServiceException {
        for(User user1:users){
            if (user1.getEmail().equals(user.getEmail())) {
                user1=user;
                return user1;
            }
        }
        throw new TaskPlannerServiceException(TaskPlannerServiceException.USER_NOT_FOUND);
    }

    @Override
    public void removeUser(String email) {
        for(User user:users){
            if (user.getEmail().equals(email)) {
                users.remove(user);
            }
        }
    }

    @Override
    public User getUser(String email, String password) {
        User usr = null;
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                usr = user;
            }
        }
        return usr;
    }
}
