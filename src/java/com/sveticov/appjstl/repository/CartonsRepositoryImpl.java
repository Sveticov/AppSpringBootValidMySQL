package com.sveticov.appjstl.repository;

import com.sveticov.appjstl.model.Cartons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CartonsRepositoryImpl {
    Logger logger = LoggerFactory.getLogger(CartonsRepositoryImpl.class);
    @Autowired()
    CartonsRepository repository;


    public void getCartons(int id_model_user) {
        Cartons cartons1;
        Set<Cartons> cartonsSet = new HashSet<>();
        Cartons[] cartons = repository.joinByIdUserModelCARTON(id_model_user);


        for (int i = 0; i < cartons.length; i++) {
            cartons1 = new Cartons();
            cartons1.setId_carton(cartons[i].getId_carton());
            cartons1.setName_carton(cartons[i].getName_carton());
            cartons1.setUser_model(null);

            cartonsSet.add(cartons1);
        }

        cartonsSet.stream().forEach(System.out::println);

    }



}
