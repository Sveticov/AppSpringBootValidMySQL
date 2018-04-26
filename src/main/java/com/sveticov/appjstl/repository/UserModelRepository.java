package com.sveticov.appjstl.repository;

import com.sveticov.appjstl.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface UserModelRepository extends JpaRepository<UserModel, Integer> {

    @Transactional
    @Query(value = "select u.* from user_model u where u.name_user_model=:name",nativeQuery = true)
    UserModel selectName(@Param("name") String name);

}
