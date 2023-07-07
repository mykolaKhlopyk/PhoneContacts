package com.scisw.phonecontacts.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "contacts")
@Data
public class Contact{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User owner;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="contacts_emails",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "email_id")
    )
    private List<Email> emails;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="contacts_phones",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "phone_id")
    )
    private List<Phone> phones;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name);
    }

}
