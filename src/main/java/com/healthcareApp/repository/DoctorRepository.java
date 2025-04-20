package com.healthcareApp.repository;

import com.healthcareApp.model.Doctor;
import com.healthcareApp.model.Person;
import com.healthcareApp.service.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepository {

    private static Connection connection = null;

    public void initConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }

    private static final List<Doctor> doctorList = new ArrayList<>();

    public boolean createDoctor(Doctor doctor) throws SQLException {

        this.initConnection();

        String query = "INSERT INTO doctor(doctorId,firstName,lastName,age,gender,contactNo,speciality,experience) VALUES(?,?,?,?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, doctor.getDoctorId());
            preparedStatement.setString(2, doctor.getFirstName());
            preparedStatement.setString(3, doctor.getLastName());
            preparedStatement.setInt(4, doctor.getAge());
            preparedStatement.setString(5, doctor.getGender());
            preparedStatement.setString(6, doctor.getContactNo());
            preparedStatement.setString(7, doctor.getSpeciality());
            preparedStatement.setLong(8, doctor.getExperience());

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

    public List<Doctor> displayDoctor() throws SQLException {

        this.initConnection();

        String query = "SELECT * FROM doctor";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Doctor doctor = new Doctor(
                        resultSet.getInt("doctorId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getInt("age"),
                        resultSet.getString("gender"),
                        resultSet.getString("contactNo"),
                        resultSet.getString("speciality"),
                        resultSet.getInt("experience")
                );


                doctorList.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctorList;
    }

    public boolean updateDoctor(int doctorId, String firstName) throws SQLException {

        this.initConnection();

        String query = "UPDATE doctor SET firstName=? WHERE doctorId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setInt(2, doctorId);

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

    public boolean DeleteDoctor(int doctorId) throws SQLException {

        this.initConnection();

        String query = "DELETE FROM doctor WHERE doctorId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, doctorId);

            int rowdeleted = preparedStatement.executeUpdate();

            return rowdeleted > 0;

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
