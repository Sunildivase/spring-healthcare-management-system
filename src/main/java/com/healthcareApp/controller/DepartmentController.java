package com.healthcareApp.controller;

import com.healthcareApp.model.Department;
import com.healthcareApp.service.DepartmentService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.Scanner;

@AllArgsConstructor
public class DepartmentController {
    private static final Scanner scanner = new Scanner(System.in);

    private DepartmentService departmentService;

    public void run() throws SQLException {

        Department department=new Department();

        int option;

        do{
            System.out.println("---Department Information----");
            System.out.println("1.Create Department");
            System.out.println("2.Retrieve Department");
            System.out.println("3.Update Department");
            System.out.println("4.Delete Department");
            System.out.println("0.Returning to Main Menu");

            System.out.println("select the option below:");
            option=Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    departmentService.createDepartment();
                    break;

                case 2:
                    departmentService.displayDepartment();
                    break;

                case 3:
                    departmentService.updateDepartment(department.getDeptId(), department.getDeptName());
                    break;

                case 4:
                    departmentService.deleteDepartment(department.getDoctorId());
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
