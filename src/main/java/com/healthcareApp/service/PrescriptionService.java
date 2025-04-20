package com.healthcareApp.service;

import com.healthcareApp.model.Appointment;
import com.healthcareApp.model.Prescription;
import com.healthcareApp.repository.AppointmentRepository;
import com.healthcareApp.repository.PrescriptionRepository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class PrescriptionService {

    private static final Scanner scanner = new Scanner(System.in);

    private PrescriptionRepository prescriptionRepository;


    void printPrescription(Prescription prescription){
        System.out.println(prescription);
    }

    public boolean createPrescription() throws SQLException {

        System.out.println("please enter prescriptionId");
        int prescriptionId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter prescriptionDetails");
        String prescriptionDetails = scanner.nextLine();

        System.out.println("please enter personId");
        int personId = Integer.parseInt(scanner.nextLine());


        Prescription prescription = new Prescription(prescriptionId,prescriptionDetails,personId);

        System.out.println("Prescription created successfully!!!");
        return prescriptionRepository.createPrescription(prescription);
    }

    public List<Prescription> displayPrescription() throws SQLException {


        List<Prescription> prescriptionList = new ArrayList<>();

        System.out.println("prescription list: "+prescriptionRepository.displayPrescription());

        return prescriptionList;
    }

    public boolean updatePrescription(int prescriptionId,String prescriptionDetails) throws SQLException {

        if (prescriptionRepository.updatePrescription(prescriptionId, prescriptionDetails)) {
            System.out.println("prescription updated successfully ");
        } else {
            System.out.println("Failed to update prescription");
        }
        return false;
    }

    public void deletePrescription(int prescriptionId) throws SQLException {

        boolean deletedPrescription= prescriptionRepository.deletePrescription(prescriptionId);
        System.out.println("deleted prescription: "+deletedPrescription);
    }
}
