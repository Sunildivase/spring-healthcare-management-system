package com.healthcareApp.model;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {
    private int prescriptionId;
    private String prescriptionDetails;
    private int personId;
}
