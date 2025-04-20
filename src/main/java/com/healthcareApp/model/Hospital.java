package com.healthcareApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hospital {
    private int hospitalId;
    private String hospitalName;
    private String address;
    private String emailId;
    private String contactNo;
}
