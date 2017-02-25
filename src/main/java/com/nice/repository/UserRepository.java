package com.nice.repository;

import com.nice.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by deepesh nellutla on 2/23/2017.
 */
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select u from User u where u.userName=:userName")
    User findByUserName(@Param("userName") String userName);
}
