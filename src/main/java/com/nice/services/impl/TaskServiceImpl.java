package com.nice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nice.Exceptions.NotFoundException;
import com.nice.data.CreateTaskRequest;
import com.nice.data.Status;
import com.nice.domain.Tasks;
import com.nice.domain.User;
import com.nice.repository.TaskRepository;
import com.nice.repository.UserRepository;
import com.nice.services.TaskService;


/**
 * Created by deepesh nellutla on 2/24/2017.
 * Implementor for Task Service
 */
@Service
public class TaskServiceImpl implements TaskService {

    TaskRepository taskRepository;
    UserRepository userRepository;

    @Autowired
    TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Tasks createTask(CreateTaskRequest createTaskRequest) {
        Tasks tasks = new Tasks();
        tasks.setDescription(createTaskRequest.getDescription());
        tasks.setName(createTaskRequest.getName());
        tasks.setStatus(createTaskRequest.getStatus());
        //User user = createTaskRequest.getUser();
        User user = userRepository.findByUserName(createTaskRequest.getUser().getUserName());
        if (user != null) {
            tasks.setUser(user);


        } else {
            tasks.setUser(createTaskRequest.getUser());
        }
        taskRepository.save(tasks);


        return tasks;
    }

    @Transactional
    public Tasks updateTask(Long id, CreateTaskRequest createTaskRequest) {
        Tasks tasks = taskRepository.findOne(id);

        if (tasks == null) {
            throw new NotFoundException("task with given id not found");
        }
        if (createTaskRequest.getName() != null) {
            tasks.setName(createTaskRequest.getName());
        }
        if (createTaskRequest.getDescription() != null) {
            tasks.setDescription(createTaskRequest.getDescription());
        }
        if (createTaskRequest.getStatus() != null) {
            tasks.setStatus(createTaskRequest.getStatus());
        }
        if (createTaskRequest.getUser() != null) {
            User user = userRepository.findByUserName(createTaskRequest.getUser().getUserName());
            if (user != null) {
                tasks.setUser(user);
            } else {
                tasks.setUser(createTaskRequest.getUser());
            }
        }
        return taskRepository.save(tasks);
    }

    public List<Tasks> getTasksForGivenStatus(Status status) {
        return taskRepository.getTasksforStatus(status);
    }

    public Iterable<Tasks> getTaskDetails() {
        return taskRepository.findAll();
    }
}
