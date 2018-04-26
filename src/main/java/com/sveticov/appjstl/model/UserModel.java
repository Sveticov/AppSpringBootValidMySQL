package com.sveticov.appjstl.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "user_model")

@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_user_model;
    private String name_user_model;
  //  private Date date_user_model;

    public UserModel() {
    }
}
