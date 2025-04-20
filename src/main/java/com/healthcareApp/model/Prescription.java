package com.healthcareApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prescription {
    private int prescriptionId;
    private String prescriptionDetails;
    private int personId;
}
