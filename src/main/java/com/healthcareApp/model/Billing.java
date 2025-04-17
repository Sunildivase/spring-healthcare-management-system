package com.healthcareApp.model;

import lombok.*;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Billing {
    private int billId;
    private double bill;
    private double totalBill;
    private int personId;
}
