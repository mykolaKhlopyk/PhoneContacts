package com.scisw.phonecontacts.controller;

import com.scisw.phonecontacts.dto.ContactDto;
import com.scisw.phonecontacts.dto.transformer.ContactTransformer;
import com.scisw.phonecontacts.service.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

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
        return new ResponseEntity<ContactDto>(contactService.update(contactDto), HttpStatus.OK);

    }

    @DeleteMapping
    public ResponseEntity<ContactDto> delete(@PathVariable String name){
        return new ResponseEntity<ContactDto>(contactService.deleteContact(name), HttpStatus.NO_CONTENT);
    }

}
