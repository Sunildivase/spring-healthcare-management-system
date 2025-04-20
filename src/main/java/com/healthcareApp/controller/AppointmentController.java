package com.healthcareApp.controller;

import com.healthcareApp.model.Appointment;
import com.healthcareApp.model.Department;
import com.healthcareApp.service.AppointmentService;
import com.healthcareApp.service.DepartmentService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.Scanner;

@AllArgsConstructor
public class AppointmentController {
    private static final Scanner scanner = new Scanner(System.in);

    private AppointmentService appointmentService;

    public void run() throws SQLException {

        Appointment appointment=new Appointment();

        int option;

        do{
            System.out.println("---Appointment Information----");
            System.out.println("1.Create Appointment");
            System.out.println("2.Retrieve Appointment");
            System.out.println("3.Update Appointment");
            System.out.println("4.Delete Appointment");
            System.out.println("0.Returning to Main Menu");

            System.out.println("select the option below:");
            option=Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    appointmentService.createAppointment();
                    break;

                case 2:
                    appointmentService.displayAppointment();
                    break;

                case 3:
                    appointmentService.updateAppointment(appointment.getAppointmentId(), appointment.getPersonId());
                    break;

                case 4:
                    appointmentService.deleteAppointment(appointment.getAppointmentId());
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
