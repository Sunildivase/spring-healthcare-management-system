package com.healthcareApp.service;

import com.healthcareApp.model.Appointment;
import com.healthcareApp.model.Billing;
import com.healthcareApp.repository.AppointmentRepository;
import com.healthcareApp.repository.BillingRepository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class BillingService {
    private static final Scanner scanner = new Scanner(System.in);

    private BillingRepository billingRepository;


    void printBilling(Billing billing){
        System.out.println(billing);
    }

    public boolean createBilling() throws SQLException {

        System.out.println("please enter billId");
        int billId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter bill");
        double bill = Double.parseDouble(scanner.nextLine());

        System.out.println("please enter total bill");
        double totalBill = Double.parseDouble(scanner.nextLine());

        System.out.println("please enter personId");
        int personId = Integer.parseInt(scanner.nextLine());


        Billing billing = new Billing(billId,bill,totalBill,personId);

        System.out.println("Billing created successfully!!!");
        return billingRepository.createBilling(billing);
    }

    public List<Billing> displayBilling() throws SQLException {


        List<Billing> billingList = new ArrayList<>();

        System.out.println("appointment list: "+billingRepository.displayBilling());

        return billingList;
    }

    public boolean updateBilling(int billId,double bill) throws SQLException {

        if (billingRepository.updateBilling(billId, bill)) {
            System.out.println("bill updated successfully ");
        } else {
            System.out.println("Failed to update bill");
        }
        return false;
    }

    public void deleteBill(int billId) throws SQLException {

        boolean deletedBill = billingRepository.deleteBilling(billId);
        System.out.println("deleted bill: "+deletedBill);
    }}
