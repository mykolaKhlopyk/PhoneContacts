package com.scisw.phonecontacts.controller;

import com.scisw.phonecontacts.dto.ContactDto;
import com.scisw.phonecontacts.dto.transformer.ContactTransformer;
import com.scisw.phonecontacts.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PutMapping
    public ResponseEntity<ContactDto> save(@Valid @RequestBody ContactDto contactDto){
        return ResponseEntity.ok(contactService.createContact(contactDto));
    }

    @GetMapping
    public ResponseEntity<Set<ContactDto>> getAllForUser(){
        return ResponseEntity.ok(contactService.getAllForUser());
    }

    @PostMapping
    public ResponseEntity<ContactDto> update(@Valid @RequestBody ContactDto contactDto){
        return ResponseEntity.ok(contactService.update(contactDto));
    }

    @DeleteMapping
    public ResponseEntity<ContactDto> delete(@PathVariable String name){
        return ResponseEntity.ok(contactService.deleteContact(name));
    }

}
