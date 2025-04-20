package com.healthcareApp.controller;

import com.healthcareApp.model.Doctor;
import com.healthcareApp.model.Person;
import com.healthcareApp.service.DoctorService;
import com.healthcareApp.service.PersonService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.Scanner;

@AllArgsConstructor
public class DoctorController {

    private static final Scanner scanner = new Scanner(System.in);

    private DoctorService doctorService;

    private Doctor doctor;

    public void run() throws SQLException {

        int option;

        do{
            System.out.println("---Doctor Information----");
            System.out.println("1.Create Doctor");
            System.out.println("2.Retrieve Doctor");
            System.out.println("3.Update Doctor");
            System.out.println("4.Delete Doctor");
            System.out.println("0.Returning to Main Menu");

            System.out.println("select the option below:");
            option=Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    doctorService.createDoctor();
                    break;

                case 2:
                    doctorService.displayDoctor();
                    break;

                case 3:
                    doctorService.updateDoctor(doctor.getDoctorId(), doctor.getFirstName());
                    break;

                case 4:
                    doctorService.deleteDoctor(doctor.getDoctorId());
                    break;

                case 0:
                    System.out.println("Returning to Main menu.");
                    break;

                default:
                    System.out.println("invalid input !!!");
            }

        }while(option!=0);{
            System.out.println("Thank You!!!");
        }
    }
}
