package com.dev.vip.menotifique.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Entity
public class Users implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    private String first_name;

    private String last_name;

    private String username;

    @JsonIgnore
    private String passwd;

    private int is_admin;

    private LocalDateTime updated_at;

    private LocalDateTime created_at;

    private int company_id;

    @ManyToMany(fetch = EAGER, cascade = ALL)
    @JoinTable(
            name = "users_has_groups1",
            joinColumns = @JoinColumn(name = "users_id", updatable = false, nullable = false),
            inverseJoinColumns = @JoinColumn(name = "groups_id", updatable = false, nullable = false)
    )
    private List<Groups> grupos = new ArrayList<>();


}
