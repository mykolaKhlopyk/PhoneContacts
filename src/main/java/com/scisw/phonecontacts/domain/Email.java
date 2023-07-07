package com.scisw.phonecontacts.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "emails")
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
