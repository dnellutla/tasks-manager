package com.nice;

import com.nice.data.Status;
import com.nice.domain.Tasks;
import com.nice.domain.User;
import com.nice.repository.TaskRepository;
import com.nice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Cigniti_1868 on 2/22/2017.
 */
@SpringBootApplication
public class Application implements CommandLineRunner{
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        Tasks tasks = new Tasks();
        Set<Tasks> set = new HashSet<Tasks>();


        tasks.setDescription("description1");
        tasks.setName("name");
        tasks.setStatus(Status.COMPLETE);
       // tasks.setUser(user);
        User user = new User("deepesh");

        //userRepository.save(user);
        tasks.setUser(user);
       // user.setTasks(tasks);
       // set.add(tasks);
        //user.setTasks(set);
        taskRepository.save(tasks);

    }
}
