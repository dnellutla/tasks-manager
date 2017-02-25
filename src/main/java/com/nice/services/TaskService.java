package com.nice.services;

import java.util.List;

import com.nice.data.CreateTaskRequest;
import com.nice.data.Status;
import com.nice.domain.Tasks;


/**
 * Created by deepesh nellutla on 2/23/2017.
 * Service Layer for Creating Tasks
 */
public interface TaskService {

    Tasks createTask(CreateTaskRequest request);

    Tasks updateTask(Long id,CreateTaskRequest request);

    List<Tasks> getTasksForGivenStatus(Status status);

    Iterable<Tasks> getTaskDetails();
}
