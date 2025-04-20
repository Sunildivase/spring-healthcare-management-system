package com.healthcareApp.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doctor {

    private int doctorId;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String contactNo;
    private String speciality;
    private int experience;
}
