package com.scisw.phonecontacts.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "phones")
@Data
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @NotBlank
    private String phoneNumber;
    @ManyToMany(mappedBy = "phones")
    private List<Contact> contacts;
}
