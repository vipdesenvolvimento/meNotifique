package com.dev.vip.menotifique.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Data
public class UserWithGroup {

    private String first_name;
    private String last_name;
    private String grupo;

    public UserWithGroup(String first_name, String last_name, String grupo){
        this.first_name = first_name;
        this.last_name = last_name;
        this.grupo = grupo;
    }
}
