package eci.ieti.taskplannerAPI.Services;

import eci.ieti.taskplannerAPI.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceStub implements UserService {
    @Override
    public List<User> getUsersList() {
        return null;
    }

    @Override
    public User getUserById(String userId) {
        return null;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void removeUser(String userId) {

    }
}
