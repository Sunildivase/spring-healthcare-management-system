package com.healthcareApp.model;

import lombok.*;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    private int appointmentId;
    private int personId;
    private int doctorId;
    private int hospitalId;
    private int deptId;
}
