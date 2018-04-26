package com.sveticov.appjstl.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "cartons_")
@Data
public class Cartons implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_carton;
    private String name_carton;
    private Set<UserModel> userModels;
}
