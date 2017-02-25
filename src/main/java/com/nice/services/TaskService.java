package com.nice.services;

import com.nice.data.CreateTaskRequest;
import com.nice.data.Status;
import com.nice.domain.Tasks;

import java.util.List;

/**
 * Created by Cigniti_1868 on 2/23/2017.
 */
public interface TaskService {

    Tasks createTask(CreateTaskRequest request);

    Tasks updateTask(Long id,CreateTaskRequest request);

    List<Tasks> getTasksForGivenStatus(Status status);

    Iterable<Tasks> getTaskDetails();
}
