package com.scisw.phonecontacts.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class EmailDto {
    @Email
    private String emailAddress;
}
