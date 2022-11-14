package com.unlockprogramming.example;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentRequest {

    private String name;

    private String email;

    private String address;

    private LocalDate dateOfBirth;

}
