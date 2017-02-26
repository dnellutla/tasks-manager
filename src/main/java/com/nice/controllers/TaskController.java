package com.nice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.nice.data.CreateTaskRequest;
import com.nice.data.Status;
import com.nice.domain.Tasks;
import com.nice.services.TaskService;



/**
 * Created by deepesh nellutla on 2/23/2017.
 * Tasks Controller has CRUD endpoints for operations on tasks
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    ResponseEntity<Tasks> createTasks(@RequestBody CreateTaskRequest request) {
        return new ResponseEntity<Tasks>(taskService.createTask(request), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    ResponseEntity<Tasks> updateTask(@PathVariable Long id, @RequestBody CreateTaskRequest request){
        return new ResponseEntity<Tasks>(taskService.updateTask(id,request),HttpStatus.OK);
    }

    @RequestMapping(value = "/{taskStatus}", method = RequestMethod.GET)
    ResponseEntity<Iterable<Tasks>> getTaskDetailsforStatusSupplied(@PathVariable Status taskStatus) {
       return new ResponseEntity<Iterable<Tasks>>(taskService.getTasksForGivenStatus(taskStatus),HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    ResponseEntity<Iterable<Tasks>> getTaskDetails() {
        return new ResponseEntity<Iterable<Tasks>>(taskService.getTaskDetails(),HttpStatus.OK);
    }

}
