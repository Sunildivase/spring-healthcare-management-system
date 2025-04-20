package com.healthcareApp.service;

import com.healthcareApp.model.Appointment;
import com.healthcareApp.model.Department;
import com.healthcareApp.repository.AppointmentRepository;
import com.healthcareApp.repository.DepartmentRepository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class AppointmentService {
    private static final Scanner scanner = new Scanner(System.in);

    private AppointmentRepository appointmentRepository;


    void printAppointment(Appointment appointment){
        System.out.println(appointment);
    }

    public boolean createAppointment() throws SQLException {

        System.out.println("please enter appointmentId");
        int appointmentId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter personId");
        int personId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter doctorId");
        int doctorId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter hospitalId");
        int hospitalId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter deptId");
        int deptId = Integer.parseInt(scanner.nextLine());

        Appointment appointment = new Appointment(appointmentId,personId,doctorId,hospitalId,deptId);

        System.out.println("Appointment created successfully!!!");
        return appointmentRepository.createAppointment(appointment);
    }

    public List<Appointment> displayAppointment() throws SQLException {


        List<Appointment> appointmentList = new ArrayList<>();

        System.out.println("appointment list: "+appointmentRepository.displayAppointment());

        return appointmentList;
    }

    public boolean updateAppointment(int appointmentId,int personId) throws SQLException {

        if (appointmentRepository.updateAppointment(appointmentId, personId)) {
            System.out.println("appointment updated successfully ");
        } else {
            System.out.println("Failed to update appointment");
        }
        return false;
    }

    public void deleteAppointment(int appointmentId) throws SQLException {

        boolean deletedAppointment = appointmentRepository.deleteAppointment(appointmentId);
        System.out.println("deleted appointment: "+deletedAppointment);
    }
}
