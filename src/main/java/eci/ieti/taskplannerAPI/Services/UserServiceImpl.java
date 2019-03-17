package eci.ieti.taskplannerAPI.Services;

import eci.ieti.taskplannerAPI.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private List<User> users;

    public UserServiceImpl() {
        users=new ArrayList<>();
        users.add(new User("nicoga97@gmail.com", "user1", "password", "Nicolas", " Garcia"));
        users.add(new User("andres@gmail.com", "user2", "password", "Andres", " Perez"));
        users.add(new User("camilo@gmail.com", "user3", "password", "Camilo", "Fajardo"));
    }

    @Override
    public List<User> getUsersList() {
        return users;
    }

    @Override
    public User getUserById(String userId) throws TaskPlannerServiceException {
        for(User user:users){
            if (user.getId() == Long.parseLong(userId)) {
                return user;
            }
        }
        throw new TaskPlannerServiceException(TaskPlannerServiceException.USER_NOT_FOUND);
    }

    @Override
    public User createUser(User user) {
        user.setId(users.size() + 1);
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(User user) throws TaskPlannerServiceException {
        for(User user1:users){
            if (user1.getId() == user.getId()) {
                user1=user;
                return user1;
            }
        }
        throw new TaskPlannerServiceException(TaskPlannerServiceException.USER_NOT_FOUND);
    }

    @Override
    public void removeUser(String userId) {
        for(User user:users){
            if (user.getId() == Long.parseLong(userId)) {
                users.remove(user);
            }
        }
    }

    @Override
    public User getUser(String username, String password) {
        User usr = null;
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                usr = user;
            }
        }
        return usr;
    }
}
