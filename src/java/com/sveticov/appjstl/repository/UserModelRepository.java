package com.sveticov.appjstl.repository;

import com.sveticov.appjstl.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;




public interface UserModelRepository extends JpaRepository<UserModel, Integer> {

    @Transactional
    @Query(value = "select u.* from user_model u where u.name_user_model=:name",nativeQuery = true)
    UserModel selectName(@Param("name") String name);

    @Query(value = " select u.name_user_model,mc.name_carton from user_model u inner join move_cartons mc on mc.id_user_model=u.id_user_model", nativeQuery = true)
   String [] selectJoin();
}
