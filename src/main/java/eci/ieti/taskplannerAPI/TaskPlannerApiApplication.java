package eci.ieti.taskplannerAPI;

import eci.ieti.taskplannerAPI.Model.Task;
import eci.ieti.taskplannerAPI.Model.User;
import eci.ieti.taskplannerAPI.config.JwtFilter;
import eci.ieti.taskplannerAPI.data.TaskRepository;
import eci.ieti.taskplannerAPI.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

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
        for (User usr : userRepository.findAllWithoutPsw()) {
            System.out.println(usr);
        }
        System.out.println("-------------------------------");
        for (Task Task : taskRepository.findTasksWithLargeDescription()) {
            System.out.println(Task);
        }

    }
}
