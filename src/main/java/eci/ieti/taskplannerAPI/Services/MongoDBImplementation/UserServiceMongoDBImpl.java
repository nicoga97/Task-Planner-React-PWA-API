package eci.ieti.taskplannerAPI.Services.MongoDBImplementation;

import eci.ieti.taskplannerAPI.Model.User;
import eci.ieti.taskplannerAPI.Services.TaskPlannerServiceException;
import eci.ieti.taskplannerAPI.Services.UserService;
import eci.ieti.taskplannerAPI.data.UserRepository;
import eci.ieti.taskplannerAPI.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UserServiceMongoDBImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsersList() {
        return userRepository.findAllWithoutPsw();
    }

    @Override
    public User getUserByEmail(String email) throws TaskPlannerServiceException {
        return userRepository.findByEmail(email);
    }

    @Override
    public User createUser(User user) {
        user.setPassword(StringUtils.getMD5Hash(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(User user) throws TaskPlannerServiceException {
        userRepository.save(user);
        return user;
    }

    @Override
    public void removeUser(String email) {
        userRepository.deleteById(email);

    }

    @Override
    public User getUser(String email) {
        List<User> users = userRepository.findAll();
        User user = null;

        for (User usr : users) {
            if (email.equals(usr.getEmail())) {
                user = usr;
            }
        }

        return user;
    }
}
