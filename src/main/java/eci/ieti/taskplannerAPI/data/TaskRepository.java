package eci.ieti.taskplannerAPI.data;

import eci.ieti.taskplannerAPI.Model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    Task findByResponsible(String responsible);

    @Query("{'dueDate':{$lt: ?0}}")
    List<Task> findExpiredTasks(LocalDate date);

    @Query("{'priority':{$gte: 5},'responsible':{$ne: null}}")
    List<Task> findTasksWithHighPriority();

    @Query("{$where: 'this.description.length > 30'}")
    List<Task> findTasksWithLargeDescription();


}
