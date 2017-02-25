package com.nice.services;

import com.nice.domain.User;

/**
 * Created by deepesh nellutla on 2/23/2017.
 * Service Layer for User Operations
 */

public interface UserService {

    Iterable<User> findAll();

    User findByIdOrUserName(String idorUserName);

    User createUser(String userName);

    User updateUser(Long id, String userName);

    void deleteUser(Long id);
}

