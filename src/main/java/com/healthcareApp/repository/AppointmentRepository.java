package com.healthcareApp.repository;

import com.healthcareApp.model.Appointment;

import com.healthcareApp.service.ConnectionService;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor

public class AppointmentRepository {

    private static Connection connection = null;

    public void initConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }



    public boolean createAppointment(Appointment appointment) throws SQLException {

        this.initConnection();

        String query = "INSERT INTO appointment(appointmentId,personId,doctorId,hospitalId,deptId) VALUES(?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, appointment.getAppointmentId());
            preparedStatement.setInt(2, appointment.getPersonId());
            preparedStatement.setInt(3, appointment.getDoctorId());
            preparedStatement.setInt(4, appointment.getHospitalId());
            preparedStatement.setInt(5, appointment.getDeptId());


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

    public List<Appointment> displayAppointment() throws SQLException {

        List<Appointment> appointmentList = new ArrayList<>();

        this.initConnection();

        String query = "SELECT * FROM appointment";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Appointment appointment = new Appointment(
                        resultSet.getInt("appointmentId"),
                        resultSet.getInt("personId"),
                        resultSet.getInt("doctorId"),
                        resultSet.getInt("hospitalId"),
                        resultSet.getInt("deptId")
                );


                appointmentList.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentList;
    }

    public boolean updateAppointment(int appointmentId, int personId) throws SQLException {

        this.initConnection();

        String query = "UPDATE appointment SET personId=? WHERE appointmentId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, personId);
            preparedStatement.setInt(2, appointmentId);

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

    public boolean deleteAppointment(int appointmentId) throws SQLException {

        this.initConnection();

        String query = "DELETE FROM appointment WHERE appointmentId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, appointmentId);

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
