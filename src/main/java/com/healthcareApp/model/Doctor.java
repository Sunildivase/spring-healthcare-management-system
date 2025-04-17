package com.healthcareApp.model;

import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {
    private int doctorId;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private long contactNo;
    private String speciality;
    private int experience;
}
