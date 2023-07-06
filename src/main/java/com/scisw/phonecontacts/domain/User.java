package com.scisw.phonecontacts.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @NotBlank
    @Column(name = "login")
    private String login;
    @NotBlank
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "owner")
    private Set<Contact> contacts;
}
