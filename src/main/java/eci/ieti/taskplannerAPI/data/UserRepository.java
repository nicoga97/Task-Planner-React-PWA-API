package eci.ieti.taskplannerAPI.data;

import eci.ieti.taskplannerAPI.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);

    @Query(value = "{'name':{$exists: true}}", fields = "{'name':1,'email':1}")
    List<User> findAllWithoutPsw();

}