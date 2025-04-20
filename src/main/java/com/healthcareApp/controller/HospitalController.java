package com.healthcareApp.controller;

import com.healthcareApp.model.Doctor;
import com.healthcareApp.model.Hospital;
import com.healthcareApp.service.DoctorService;
import com.healthcareApp.service.HospitalService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.Scanner;

@AllArgsConstructor
public class HospitalController {
    private static final Scanner scanner = new Scanner(System.in);

    private HospitalService hospitalService;

    public void run() throws SQLException {

       Hospital hospital = new Hospital();

        int option;

        do{
            System.out.println("---Hospital Information----");
            System.out.println("1.Create Hospital");
            System.out.println("2.Retrieve Hospital");
            System.out.println("3.Update Hospital");
            System.out.println("4.Delete Hospital");
            System.out.println("0.Returning to Main Menu");

            System.out.println("select the option below:");
            option=Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    hospitalService.createHospital();
                    break;

                case 2:
                    hospitalService.displayHospital();
                    break;

                case 3:
                    hospitalService.updateHospital(hospital.getHospitalId(), hospital.getHospitalName());
                    break;

                case 4:
                    hospitalService.deleteHospital(hospital.getHospitalId());
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
