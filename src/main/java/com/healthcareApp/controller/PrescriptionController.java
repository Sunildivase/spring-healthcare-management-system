package com.healthcareApp.controller;

import com.healthcareApp.model.Appointment;
import com.healthcareApp.model.Prescription;
import com.healthcareApp.service.AppointmentService;
import com.healthcareApp.service.PrescriptionService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.Scanner;

@AllArgsConstructor
public class PrescriptionController {

    private static final Scanner scanner = new Scanner(System.in);

    private PrescriptionService prescriptionService;

    public void run() throws SQLException {

        Prescription prescription = new Prescription();

        int option;

        do {
            System.out.println("---Prescription Information----");
            System.out.println("1.Create Prescription");
            System.out.println("2.Retrieve Prescription");
            System.out.println("3.Update Prescription");
            System.out.println("4.Delete Prescription");
            System.out.println("0.Returning to Main Menu");

            System.out.println("select the option below:");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    prescriptionService.createPrescription();
                    break;

                case 2:
                    prescriptionService.displayPrescription();
                    break;

                case 3:
                    prescriptionService.updatePrescription(prescription.getPrescriptionId(), prescription.getPrescriptionDetails());
                    break;

                case 4:
                    prescriptionService.deletePrescription(prescription.getPrescriptionId());
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
