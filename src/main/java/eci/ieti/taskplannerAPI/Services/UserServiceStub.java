package eci.ieti.taskplannerAPI.Services;

import eci.ieti.taskplannerAPI.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceStub implements UserService {
    private List<User> users;

    public UserServiceStub() {
        users=new ArrayList<>();
        users.add(new User("Nicolas Garcia","nicoga97@gmail.com","1"));
        users.add(new User("Andres Perez","andres@gmail.com","2"));
        users.add(new User("Camilo Fajardo","camilo@gmail.com","3"));
    }

    @Override
    public List<User> getUsersList() {
        return users;
    }

    @Override
    public User getUserById(String userId) throws TaskPlannerServiceException {
        for(User user:users){
            if(user.getId().equals(userId)){
                return user;
            }
        }
        throw new TaskPlannerServiceException(TaskPlannerServiceException.USER_NOT_FOUND);
    }

    @Override
    public User createUser(User user) {
        user.setId( Integer.toString(users.size()+1));
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(User user) throws TaskPlannerServiceException {
        for(User user1:users){
            if(user1.getId().equals(user.getId())){
                user1=user;
                return user1;
            }
        }
        throw new TaskPlannerServiceException(TaskPlannerServiceException.USER_NOT_FOUND);
    }

    @Override
    public void removeUser(String userId) {
        for(User user:users){
            if(user.getId().equals(userId)){
                users.remove(user);
            }
        }
    }
}
