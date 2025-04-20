package com.healthcareApp.service;

import com.healthcareApp.model.Department;
import com.healthcareApp.model.Doctor;
import com.healthcareApp.model.Person;
import com.healthcareApp.repository.DepartmentRepository;
import com.healthcareApp.repository.DoctorRepository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor

public class DepartmentService {


    private static final Scanner scanner = new Scanner(System.in);

    private DepartmentRepository departmentRepository;


    void printDepartment(Department department){
        System.out.println(department);
    }

    public boolean createDepartment() throws SQLException {

        System.out.println("please enter deptId");
        int deptId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter deptName");
        String deptName = scanner.nextLine();

        System.out.println("please enter doctorId");
        int doctorId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter hospitalId");
        int hospitalId = Integer.parseInt(scanner.nextLine());

        Department department = new Department(deptId,deptName,doctorId,hospitalId);

        System.out.println("Department created successfully!!!");
        return departmentRepository.createDepartment(department);
    }

    public List<Department> displayDepartment() throws SQLException {

        Department department = new Department();

        List<Department> departmentList = new ArrayList<>();

        System.out.println("Department list: "+departmentRepository.displayDepartment());

        return departmentList;
    }

    public boolean updateDepartment(int deptId,String deptName) throws SQLException {

        if (departmentRepository.updateDepartment(deptId, deptName)) {
            System.out.println("Department updated successfully ");
        } else {
            System.out.println("Failed to update Department");
        }
        return false;
    }

    public void deleteDepartment(int deptId) throws SQLException {

        boolean deletedDepartment = departmentRepository.deleteDepartment(deptId);
        System.out.println("deleted department: "+deletedDepartment);
    }
}
