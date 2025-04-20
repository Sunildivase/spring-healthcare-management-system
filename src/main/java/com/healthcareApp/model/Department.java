package com.healthcareApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private int deptId;
    private String deptName;
    private int doctorId;
    private int hospitalId;
}
