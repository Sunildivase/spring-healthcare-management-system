package com.healthcareApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    private int appointmentId;
    private int personId;
    private int doctorId;
    private int hospitalId;
    private int deptId;
}
