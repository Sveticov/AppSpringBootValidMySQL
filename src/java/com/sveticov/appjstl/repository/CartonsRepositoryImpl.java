package com.sveticov.appjstl.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Repository(value = "cartons")
public class CartonsRepositoryImpl {
    @Autowired()
    CartonsRepository repository;
}
