package eci.ieti.taskplannerAPI.data;

import eci.ieti.taskplannerAPI.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);


}