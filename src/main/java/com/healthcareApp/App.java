package com.healthcareApp;

import com.healthcareApp.controller.PersonController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        int option;

        do{
            System.out.println("------spring-healthcare-management-system------");
            System.out.println("1.create Person");
            System.out.println("2.create Doctor");
            System.out.println("3.create Hospital");
            System.out.println("4.create Department");
            System.out.println("5.create Appointment");
            System.out.println("6.create Prescription");
            System.out.println("7.create billing");

            System.out.println("select the option below");
            option = Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
                    PersonController personController = context.getBean("personController",PersonController.class);
//                    PersonController personController = new PersonController();
                    personController.run();
                    System.out.println("person successfully created");
                    break;

                case 2:
                    System.out.println("doctor successfully created");
                    break;

                case 3:
                    System.out.println("hospital created successfully");
                    break;

                case 4:
                    System.out.println("department created successfully");
                    break;

                case 5:
                    System.out.println("appointment created successfully");
                    break;

                case 6:
                    System.out.println("prescription created successfully");
                    break;

                case 7:
                    System.out.println("billing created successfully");
                    break;

                default:
                    System.out.println("please enter valid input");
                    break;
            }

        }while(option!=0);{
            System.out.println("please enter valid option");
        }

    }
}

