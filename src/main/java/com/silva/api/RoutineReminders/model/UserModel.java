package com.silva.api.RoutineReminders.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String amazon_user_id;

    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAmazon_user_id() {
        return amazon_user_id;
    }

    public void setAmazon_user_id(String amazon_user_id) {
        this.amazon_user_id = amazon_user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
