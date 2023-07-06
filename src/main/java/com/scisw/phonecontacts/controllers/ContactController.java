package com.scisw.phonecontacts.controllers;

import com.scisw.phonecontacts.dto.ContactDto;
import com.scisw.phonecontacts.dto.PhoneDto;
import com.scisw.phonecontacts.dto.transformers.ContactTransformer;
import com.scisw.phonecontacts.repository.ContactRepository;
import com.scisw.phonecontacts.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping
    private ResponseEntity<ContactDto> save(@Valid @RequestBody ContactDto contactDto){
        return ResponseEntity.ok(ContactTransformer.convertToDto(contactService.createContact(contactDto)));
    }

}
