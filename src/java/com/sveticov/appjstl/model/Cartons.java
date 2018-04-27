package com.sveticov.appjstl.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "move_cartons")
@Data
public class Cartons implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_carton;
    private String name_carton;
  //  private int id_user_model;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user_model")
    private UserModel user_model;

    public Cartons() {
    }

    public Cartons(String name_carton) {
        this.name_carton = name_carton;
    }
}
