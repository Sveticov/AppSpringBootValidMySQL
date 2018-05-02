package com.sveticov.appjstl.repository;

import com.sveticov.appjstl.model.Cartons;
import com.sveticov.appjstl.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Set;


public interface UserModelRepository extends JpaRepository<UserModel, Integer> {

    @Transactional
    @Query(value = "select u.* from user_model u where u.name_user_model=:name",nativeQuery = true)
    UserModel selectName(@Param("name") String name);

    @Query(value = " select u.name_user_model,mc.name_carton from user_model u inner join move_cartons mc on mc.id_user_model=u.id_user_model", nativeQuery = true)
   String [] selectJoin();


    @Query(value = "select u.id_user_model,u.name_user_model,mc.id_carton,mc.name_carton from move_cartons mc  inner join user_model u on mc.id_user_model = u.id_user_model and u.id_user_model=:id_user_model",nativeQuery = true)
    String [] joinByIdUserModel(@Param("id_user_model") int id_user_model);


    @Query(value = "select u.id_user_model,u.name_user_model from user_model u where u.id_user_model=:id_user_model",nativeQuery = true)
    UserModel joinByIdUserModeMODEL(@Param("id_user_model") int id_user_model);


}
