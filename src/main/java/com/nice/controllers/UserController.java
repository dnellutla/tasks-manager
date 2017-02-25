package com.nice.controllers;

import com.nice.data.CreateUserRequest;
import com.nice.domain.User;
import com.nice.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by deepesh nellutla on 2/23/2017.
 * User Controller which has the CRUD endpoints on a User
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    ResponseEntity<Iterable<User>> getAllUsers() {
        return new ResponseEntity<Iterable<User>>(userService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<User> getUserByIdOrUserName(@PathVariable("id") String idOrUserName) {
        return new ResponseEntity(userService.findByIdOrUserName(idOrUserName), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    ResponseEntity<User> createUser(@RequestBody CreateUserRequest request) {
        return new ResponseEntity(userService.createUser(request.getUserName()), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody CreateUserRequest request) {
        return new ResponseEntity(userService.updateUser(id, request.getUserName()), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}

