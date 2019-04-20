package eci.ieti.taskplannerAPI.Services;

import eci.ieti.taskplannerAPI.Model.User;

import java.util.List;

public interface UserService {
    List<User> getUsersList();

    User getUserByEmail(String email) throws TaskPlannerServiceException;

    User createUser(User user);

    User updateUser(User user) throws TaskPlannerServiceException;

    void removeUser(String email);

    User getUser(String email);
}