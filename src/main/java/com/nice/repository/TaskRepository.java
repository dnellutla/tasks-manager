package com.nice.repository;

import com.nice.data.Status;
import com.nice.domain.Tasks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by deepesh nellutla on 2/24/2017.
 */
public interface TaskRepository extends CrudRepository<Tasks,Long> {
    @Query("select t from Tasks t where t.status=:status")
    List<Tasks> getTasksforStatus(@Param("status") Status status);
}
