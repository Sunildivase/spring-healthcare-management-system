package com.healthcareApp.model;

import lombok.*;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
    private int hospitalId;
    private String hospitalName;
    private String address;
    private String emailId;
    private long contactNo;
}
