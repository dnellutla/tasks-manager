package com.nice.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nice.Exceptions.NotFoundException;
import com.nice.domain.User;
import com.nice.repository.UserRepository;
import com.nice.services.UserService;




/**
 * Created by deepesh nellutla on 2/23/2017.
 * Implementor of the User Service.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User findByIdOrUserName(String idOrUserName) {
        User user;

        try {
            Long id = new Long(idOrUserName);
            user = userRepository.findOne(id);
        } catch (Exception e) {
            user = null;
        }

        if (user == null) {
            user = userRepository.findByUserName(idOrUserName);
        }

        return user;
    }

    @Transactional
    public User createUser(String userName) {
        User user = new User(userName);
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(Long id, String userName) {
        try {
            User user = userRepository.findOne(id);
            if (user == null) {
                throw new NotFoundException("task with given id not found");
            }
            user.setUserName(userName);
            return userRepository.save(user);
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new NotFoundException("user with given userName not found");
        }
        userRepository.delete(user.getId());
    }
}
