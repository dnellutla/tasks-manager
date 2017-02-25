package com.nice.services;

import com.nice.domain.User;

/**
 * Created by Cigniti_1868 on 2/22/2017.
 */

public interface UserService {

    Iterable<User> findAll();

    User findByIdOrUserName(String idorUserName);

    User createUser(String userName);

    User updateUser(Long id, String userName);

    void deleteUser(String userName);
}
