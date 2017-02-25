package com.nice.controllers;

import com.nice.data.CreateUserRequest;
import com.nice.domain.User;
import com.nice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
/**
 * Created by deepesh nellutla on 2/23/2017.
 */
@RestController
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    User getUserByIdOrUserName(@PathVariable("id") String idOrUserName) {
        return userService.findByIdOrUserName(idOrUserName);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    User createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request.getUserName());
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    User updateUser(@PathVariable("id") Long id, @RequestBody CreateUserRequest request) {
        return userService.updateUser(id, request.getUserName());
    }
    @RequestMapping(value = "/users/{userName}", method = RequestMethod.DELETE)
    void deleteUser(@PathVariable("userName") String userName) {
        userService.deleteUser(userName);
    }


}

