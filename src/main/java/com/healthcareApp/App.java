
package com.healthcareApp;

import com.healthcareApp.controller.PersonController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);

    private static ApplicationContext context;

    public static void main(String[] args) throws SQLException {

        // Debug print statement
        System.out.println("Starting Spring context...");

        // Load Spring context
        context = new ClassPathXmlApplicationContext("spring.xml");

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

                    // Getting the bean and calling the method
                    PersonController personController = (PersonController)context.getBean("personController", PersonController.class);
                    personController.run();
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
