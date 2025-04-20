package com.healthcareApp.controller;

import com.healthcareApp.model.Appointment;
import com.healthcareApp.model.Billing;
import com.healthcareApp.service.AppointmentService;
import com.healthcareApp.service.BillingService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.Scanner;

@AllArgsConstructor
public class BillingController {
    private static final Scanner scanner = new Scanner(System.in);

    private BillingService billingService;

    public void run() throws SQLException {

        Billing billing = new Billing();

        int option;

        do {
            System.out.println("---Billing Information----");
            System.out.println("1.Create Billing");
            System.out.println("2.Retrieve Billing");
            System.out.println("3.Update Billing");
            System.out.println("4.Delete Billing");
            System.out.println("0.Returning to Main Menu");

            System.out.println("select the option below:");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    billingService.createBilling();
                    break;

                case 2:
                    billingService.displayBilling();
                    break;

                case 3:
                    billingService.updateBilling(billing.getBillId(), billing.getBill());
                    break;

                case 4:
                    billingService.deleteBill(billing.getBillId());
                    break;

                case 0:
                    System.out.println("Returning to Main menu.");
                    break;

                default:
                    System.out.println("invalid input !!!");
            }

        } while (option != 0);
        {
            System.out.println("Thank You!!!");
        }
    }
}
