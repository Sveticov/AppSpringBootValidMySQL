package com.sveticov.appjstl.repository;

import com.sveticov.appjstl.model.Cartons;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CartonsRepository extends JpaRepository<Cartons,Integer> {
}
