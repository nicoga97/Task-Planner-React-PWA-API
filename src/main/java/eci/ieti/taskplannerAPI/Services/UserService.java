package eci.ieti.taskplannerAPI.Services;

import eci.ieti.taskplannerAPI.Model.User;

import java.util.List;

public interface UserService {
    List<User> getUsersList();

    User getUserById(String userId) throws TaskPlannerServiceException;

    User createUser(User user);

    User updateUser(User user) throws TaskPlannerServiceException;

    void removeUser(String userId);

    User getUser(String username, String password);
}