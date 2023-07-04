package com.scisw.phonecontacts.domain;

import java.util.List;

public class User {
    private long id;
    private String login;
    private String password;
    List<Contact> contacts;
}
