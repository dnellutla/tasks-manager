package com.nice.test;

import com.nice.Exceptions.NotFoundException;
import com.nice.data.CreateTaskRequest;
import com.nice.data.Status;
import com.nice.domain.Tasks;
import com.nice.domain.User;
import com.nice.repository.TaskRepository;
import com.nice.repository.UserRepository;
import com.nice.services.impl.TaskServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anySet;
import static org.mockito.Matchers.anySetOf;

/**
 * Created by deepesh nellutla on 2/24/2017.
 * Unit Tests for Task Service
 */
public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TaskServiceImpl taskServiceImpl;

    private String testUserName = "testUserName1";
    private String testDescription = "testDescription";
    private String testName = "testName";
    private Status testStatus = Status.NOT_STARTED;
    private User testUser;
    private Tasks tasks;
    private CreateTaskRequest request;
    private Set<Tasks> tasksSet = new HashSet<Tasks>();
    private List<Tasks> tasksList = new ArrayList<Tasks>();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        testUser = new User(testUserName);
        tasks=new Tasks();
        request = new CreateTaskRequest(testName, testDescription, testStatus, testUser);
    }

    @Test(expected = NotFoundException.class)
    public void checkNotFoundException() {
        given(userRepository.findByUserName(testUserName)).willReturn(null);
        taskServiceImpl.updateTask(1L, request);
    }

    @Test
    public void createTaskTest() {
        Mockito.when(userRepository.findByUserName(testUserName)).thenReturn(testUser);
        Mockito.when(taskRepository.save(Mockito.any(Tasks.class))).thenReturn(tasks);
        taskServiceImpl.createTask(request);
        assertNotNull(tasks);
        assertNotNull(tasks.getId());
    }

    @Test
    public void updateTaskTest() {
        Mockito.when(taskRepository.findOne(1L)).thenReturn(tasks);
        Mockito.when(taskRepository.save(Mockito.any(Tasks.class))).thenReturn(tasks);
        Tasks tasks = taskServiceImpl.updateTask(1L, request);
        assertNotNull(tasks);
        assertNotNull(tasks.getId());
        assertEquals(tasks.getDescription(),testDescription);
        assertEquals(tasks.getName(),testName);
        assertEquals(tasks.getStatus(),testStatus);
        assertEquals(tasks.getUser(),testUser);
    }

    @Test
    public void getAllTasksTest() {
        Mockito.when(taskRepository.findAll()).thenReturn(tasksSet);
        taskServiceImpl.getTaskDetails();
        assertNotNull(tasksSet);
    }

   @Test
    public void getTaskForGivenStatusTest() {
        Mockito.when(taskRepository.getTasksforStatus(Status.IN_PROGRESS)).thenReturn(tasksList);
       taskServiceImpl.getTasksForGivenStatus(Status.IN_PROGRESS);
       assertNotNull(tasksList);
    }
}
