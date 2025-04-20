package com.healthcareApp.repository;

import com.healthcareApp.model.Department;
import com.healthcareApp.service.ConnectionService;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class DepartmentRepository {

    private static Connection connection = null;

    public void initConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }



    public boolean createDepartment(Department department) throws SQLException {

        this.initConnection();

        String query = "INSERT INTO department(deptId,deptName,doctorId,hospitalId) VALUES(?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, department.getDeptId());
            preparedStatement.setString(2, department.getDeptName());
            preparedStatement.setInt(3, department.getDoctorId());
            preparedStatement.setInt(4, department.getHospitalId());


            int rowInserted = preparedStatement.executeUpdate();

            return rowInserted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public List<Department> displayDepartment() throws SQLException {

        List<Department> departmentList = new ArrayList<>();
        
        this.initConnection();

        String query = "SELECT * FROM department";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Department department = new Department(
                        resultSet.getInt("deptId"),
                        resultSet.getString("deptName"),
                        resultSet.getInt("doctorId"),
                        resultSet.getInt("hospitalId")
                );


                departmentList.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentList;
    }

    public boolean updateDepartment(int deptId, String deptName) throws SQLException {

        this.initConnection();

        String query = "UPDATE department SET deptName=? WHERE deptId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, deptName);
            preparedStatement.setInt(2, deptId);

            int rowUpdated = preparedStatement.executeUpdate();

            return rowUpdated > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public boolean deleteDepartment(int deptId) throws SQLException {

        this.initConnection();

        String query = "DELETE FROM department WHERE deptId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, deptId);

            int rowDeleted = preparedStatement.executeUpdate();

            return rowDeleted > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }


}
