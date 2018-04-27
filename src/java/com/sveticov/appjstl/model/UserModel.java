package com.sveticov.appjstl.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

import java.util.List;
import java.util.Set;

@Table(name = "user_model")
@Entity
@Data
public class UserModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_user_model;
    private String name_user_model;
    @OneToMany(mappedBy = "user_model",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Cartons> cartons;

    public UserModel() {
    }

    public UserModel(String name_user_model) {
        this.name_user_model = name_user_model;
    }



}
