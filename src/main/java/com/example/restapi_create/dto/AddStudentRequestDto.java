package com.example.restapi_create.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



    @Data
    public class AddStudentRequestDto {
       @NotBlank(message = "Name is must")
       @Size(min = 2, max = 70 , message = "Length should range from 2 to 70")
        private String name;
        @Email
        @NotBlank(message = "Email is REQUIRED")
        private String email;

    }


