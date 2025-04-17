package com.healthcareApp.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Person {
    private int personId;
    private String type;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private long contactNo;
    private long alternateMobile;
    private String address;
}
