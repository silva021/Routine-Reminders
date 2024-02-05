package com.silva.api.RoutineReminders.repository;

import com.silva.api.RoutineReminders.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    @Query(value = "select id from tb_user where amazon_user_id = :amazonUserId", nativeQuery = true)
    Integer getIdByAmazonId(@Param(value = "amazonUserId") String amazonUserId);
}
