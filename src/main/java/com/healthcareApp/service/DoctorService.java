package com.healthcareApp.service;

import com.healthcareApp.model.Doctor;
import com.healthcareApp.model.Person;
import com.healthcareApp.repository.DoctorRepository;

import javax.print.Doc;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorService {

    private static final Scanner scanner = new Scanner(System.in);

    private DoctorRepository doctorRepository;


    void printDoctor(Person person){
        System.out.println(person);
    }

    public boolean createDoctor() throws SQLException {

        System.out.println("please enter doctorId");
        int doctorId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter firstName");
        String firstName = scanner.nextLine();

        System.out.println("please enter lastName");
        String lastName = scanner.nextLine();

        System.out.println("please enter age");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter gender");
        String gender = scanner.nextLine();

        System.out.println("please enter contactNo");
        String  contactNo = scanner.nextLine();

        System.out.println("please enter address");
        String speciality = scanner.nextLine();

        System.out.println("please enter experience");
        int experience = Integer.parseInt(scanner.nextLine());

        Doctor doctor = new Doctor(doctorId,firstName,lastName,age,gender,contactNo,speciality,experience);

        System.out.println("person created successfully!!!");
        return doctorRepository.createDoctor(doctor);
    }

    public List<Doctor> displayDoctor() throws SQLException {

        Doctor doctor = new Doctor();

        List<Doctor> doctorList = new ArrayList<>();

        System.out.println("person list: "+doctorRepository.displayDoctor());

        return doctorList;
    }

    public boolean updateDoctor(int doctorId,String firstName) throws SQLException {

        if (doctorRepository.updatePerson(doctorId, firstName)) {
            System.out.println("person updated successfully ");
        } else {
            System.out.println("Failed to update person");
        }
        return false;
    }

    public void deleteDoctor(int doctorId) throws SQLException {

        boolean deletedDoctor = doctorRepository.deleteDoctor(doctorId);
        System.out.println("deleted person: "+deletedDoctor);
    }
}
