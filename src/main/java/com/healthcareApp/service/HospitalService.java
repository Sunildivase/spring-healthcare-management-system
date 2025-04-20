package com.healthcareApp.service;

import com.healthcareApp.model.Doctor;
import com.healthcareApp.model.Hospital;
import com.healthcareApp.model.Person;
import com.healthcareApp.repository.DoctorRepository;
import com.healthcareApp.repository.HospitalRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@Data
public class HospitalService {

    private static final Scanner scanner = new Scanner(System.in);

    private HospitalRepository hospitalRepository;


    void printHospital(Hospital hospital){
        System.out.println(hospital);
    }

    public boolean createHospital() throws SQLException {

        System.out.println("please enter hospitalId");
        int hospitalId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter hospitalName");
        String hospitalName = scanner.nextLine();

        System.out.println("please enter address");
        String address = scanner.nextLine();

        System.out.println("please enter emailId");
        String emailId = scanner.nextLine();

        System.out.println("please enter contactNo");
        String contactNo = scanner.nextLine();

        Hospital hospital = new Hospital(hospitalId,hospitalName,address,emailId,contactNo);

        System.out.println("person created successfully!!!");
        return hospitalRepository.createHospital(hospital);
    }

    public List<Hospital> displayHospital() throws SQLException {

        Hospital hospital = new Hospital();

        List<Hospital> hospitalList = new ArrayList<>();

        System.out.println("hospital list: "+hospitalRepository.displayHospital());

        return hospitalList;
    }

    public boolean updateHospital(int hospitalId,String hospitalName) throws SQLException {

        if (hospitalRepository.updateHospital(hospitalId, hospitalName)) {
            System.out.println("hospital updated successfully ");
        } else {
            System.out.println("Failed to update hospital");
        }
        return false;
    }

    public void deleteHospital(int hospitalId) throws SQLException {

        boolean deletedHospital = hospitalRepository.deleteHospital(hospitalId);
        System.out.println("deleted hospital: "+deletedHospital);
    }
}
