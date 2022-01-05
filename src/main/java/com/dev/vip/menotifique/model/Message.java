package com.dev.vip.menotifique.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String description;

    private int last_msg;

    private int is_active;

    private String name;

    private String texto;

    private String texto_fonetico;

    private int hangup;

    private String id_audio;
}
