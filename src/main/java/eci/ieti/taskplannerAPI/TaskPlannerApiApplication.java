package eci.ieti.taskplannerAPI;

import eci.ieti.taskplannerAPI.Model.Task;
import eci.ieti.taskplannerAPI.Model.User;
import eci.ieti.taskplannerAPI.config.AppConfiguration;
import eci.ieti.taskplannerAPI.config.JwtFilter;
import eci.ieti.taskplannerAPI.data.TaskRepository;
import eci.ieti.taskplannerAPI.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class TaskPlannerApiApplication implements CommandLineRunner {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(TaskPlannerApiApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;
    }

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");
        userRepository.deleteAll();
        taskRepository.deleteAll();
        userRepository.save(new User("andres@gmail.com", "password", "Andres"));
        userRepository.save(new User("camilo@gmail.com", "password", "Camilo"));
        userRepository.save(new User("juan@gmail.com", "password", "juan"));
        userRepository.save(new User("andrea@gmail.com", "password", "Andrea"));
        userRepository.save(new User("camila@gmail.com", "password", "Camila"));
        userRepository.save(new User("raul@gmail.com", "password", "Raul"));
        userRepository.save(new User("javier@gmail.com", "password", "Javier"));
        userRepository.save(new User("diego@gmail.com", "password", "Diego"));
        userRepository.save(new User("jaime@gmail.com", "password", "Jaime"));
        userRepository.save(new User("diana@gmail.com", "password", "Diana"));
        userRepository.save(new User("daniela@gmail.com", "password", "Daniela"));
        taskRepository.save(new Task("Make the front end", 10, LocalDate.of(2019, 1, 23), new User("camila@gmail.com", "Camila"), Task.DONE));
        taskRepository.save(new Task("Make the back end", 10, LocalDate.of(2019, 1, 23), new User("andres@gmail.com", "Andres"), Task.DONE));
        taskRepository.save(new Task("Implement mongodb database", 5, LocalDate.of(2019, 3, 23), new User("camila@gmail.com", "Camila"), Task.IN_PROGRESS));
        taskRepository.save(new Task("Implement firebase hosting for the project", 3, LocalDate.of(2019, 2, 2), new User("jaime@gmail.com", "Jaime"), Task.READY));
        taskRepository.save(new Task("Implement real time database in firebase", 7, LocalDate.of(2019, 3, 31), new User("diana@gmail.com", "Diana"), Task.IN_PROGRESS));
        taskRepository.save(new Task("Implement continuos delivery of the project with Travis", 8, LocalDate.of(2019, 1, 10), new User("diego@gmail.com", "Diego"), Task.DONE));
        taskRepository.save(new Task("Make front end design corrections ", 2, LocalDate.of(2019, 4, 5), new User("diego@gmail.com", "Diego"), Task.IN_PROGRESS));
        taskRepository.save(new Task("Implement functions on firebase", 1, LocalDate.of(2019, 4, 20), new User("diego@gmail.com", "Diego"), Task.IN_PROGRESS));
        taskRepository.save(new Task("Get a google maps API", 9, LocalDate.of(2019, 2, 22), new User("raul@gmail.com", "Raul"), Task.DONE));
        taskRepository.save(new Task("Implement google maps API into the project", 9, LocalDate.of(2019, 4, 10), new User("raul@gmail.com", "Raul"), Task.IN_PROGRESS));
        taskRepository.save(new Task("Implement geocoder into the project", 7, LocalDate.of(2019, 4, 23), new User("daniela@gmail.com", "Daniela"), Task.IN_PROGRESS));
        taskRepository.save(new Task("Lunch the product to the investors", 10, LocalDate.of(2019, 6, 2), new User("javier@gmail.com", "Javier"), Task.IN_PROGRESS));
        taskRepository.save(new Task("Get a visual disigner for the frontend", 7, LocalDate.of(2019, 4, 10), new User("javier@gmail.com", "Javier"), Task.IN_PROGRESS));
        taskRepository.save(new Task("Migrate the mongodb database into firebase", 3, LocalDate.of(2019, 3, 31), new User("javier@gmail.com", "Javier"), Task.DONE));
        taskRepository.save(new Task("Update Readme project information", 2, LocalDate.of(2019, 4, 1), new User("camila@gmail.com", "Camila"), Task.DONE));
        taskRepository.save(new Task("Make a github organization for the project", 3, LocalDate.of(2019, 1, 1), new User("camilo@gmail.com", "Camilo"), Task.DONE));
        taskRepository.save(new Task("Fix application bugs", 6, LocalDate.of(2019, 5, 23), new User("camilo@gmail.com", "Camilo"), Task.IN_PROGRESS));
        taskRepository.save(new Task("Implement Circle CI", 1, LocalDate.of(2019, 4, 5), new User("camilo@gmail.com", "Camilo"), Task.DONE));
        taskRepository.save(new Task("Documment code", 1, LocalDate.of(2019, 3, 23), new User("camila@gmail.com", "Camila"), Task.DONE));
        taskRepository.save(new Task("Assign the project", 9, LocalDate.of(2019, 1, 1), new User("camilo@gmail.com", "Camilo"), Task.IN_PROGRESS));
        taskRepository.save(new Task("Change front end team", 6, LocalDate.of(2019, 4, 2), new User("javier@gmail.com", "Javier"), Task.IN_PROGRESS));
        taskRepository.save(new Task("Implement materialUi in the front end", 9, LocalDate.of(2019, 1, 23), new User("diana@gmail.com", "Diana"), Task.DONE));
        taskRepository.save(new Task("Make unit test for the back end", 6, LocalDate.of(2019, 1, 23), new User("camila@gmail.com", "Camila"), Task.DONE));
        taskRepository.save(new Task("Make unit test for the front end", 6, LocalDate.of(2019, 1, 23), new User("camila@gmail.com", "Camila"), Task.DONE));
        taskRepository.save(new Task("Construct the base of the project", 10, LocalDate.of(2019, 1, 1), new User("javier@gmail.com", "Javier"), Task.DONE));
        System.out.println("-------------------------------");
        for (User usr : userRepository.findAll()) {
            System.out.println(usr);
        }
        System.out.println("-------------------------------");
        for (Task Task : taskRepository.findAll()) {
            System.out.println(Task);
        }
        System.out.println("-------------------------------");
        for (Task Task : taskRepository.findExpiredTasks(LocalDate.now())) {
            System.out.println(Task);
        }
        System.out.println("-------------------------------");
        for (Task Task : taskRepository.findTasksWithHighPriority()) {
            System.out.println(Task);
        }
        System.out.println("-------------------------------");
        ArrayList<User> usersWithMoreThan2TasksAssigned = new ArrayList<>();
        for (User usr : userRepository.findAll()) {
            int cont = 0;
            for (Task task : taskRepository.findAll()) {
                if (usr.getEmail().equals(task.getResponsible().getEmail())) {
                    cont++;
                } else if (cont == 2) {
                    usersWithMoreThan2TasksAssigned.add(task.getResponsible());
                    break;
                }
            }
        }
        for (User usr : usersWithMoreThan2TasksAssigned) {
            System.out.println(usr);
        }
        System.out.println("-------------------------------");
        for (Task Task : taskRepository.findTasksWithLargeDescription()) {
            System.out.println(Task);
        }

    }
}
