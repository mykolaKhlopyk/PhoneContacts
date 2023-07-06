package com.scisw.phonecontacts.controller;

import com.scisw.phonecontacts.dto.ContactDto;
import com.scisw.phonecontacts.dto.transformer.ContactTransformer;
import com.scisw.phonecontacts.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<ContactDto> save(@Valid @RequestBody ContactDto contactDto){
        return ResponseEntity.ok(ContactTransformer.convertToDto(contactService.createContact(contactDto)));
    }

}
