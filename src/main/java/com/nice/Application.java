package com.nice;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nice.data.Status;
import com.nice.domain.Tasks;
import com.nice.domain.User;
import com.nice.repository.TaskRepository;
import com.nice.repository.UserRepository;

/**
 * Created by deepesh nellutla on 2/23/2017.
 * Class to launch SpringBoot App.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    TaskRepository taskRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        Tasks tasks = new Tasks();
        tasks.setDescription("description1");
        tasks.setName("name");
        tasks.setStatus(Status.NOT_STARTED);
        User user = new User("test user");
        tasks.setUser(user);
        taskRepository.save(tasks);

    }
}
