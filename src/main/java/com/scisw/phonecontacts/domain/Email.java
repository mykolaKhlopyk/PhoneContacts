package com.scisw.phonecontacts.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @jakarta.validation.constraints.Email
    @Column(name = "email_address ")
    private String emailAddress;

    @ManyToMany(mappedBy = "emails")
    private List<Contact> contacts;
}
