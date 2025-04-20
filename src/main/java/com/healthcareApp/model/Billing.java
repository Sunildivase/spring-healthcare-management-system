package com.healthcareApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Billing {
    private int billId;
    private double bill;
    private double totalBill;
    private int personId;
}
