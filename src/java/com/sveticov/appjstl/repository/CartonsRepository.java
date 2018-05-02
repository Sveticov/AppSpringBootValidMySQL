package com.sveticov.appjstl.repository;

import com.sveticov.appjstl.model.Cartons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;


public interface CartonsRepository extends JpaRepository<Cartons,Integer> {

    @Query(value = "select mc.id_carton, mc.name_carton , mc.id_user_model from move_cartons mc  where mc.id_user_model=:id_model_user",nativeQuery = true)
   Cartons[] joinByIdUserModelCARTON(@Param("id_model_user") int id_model_user);
}
