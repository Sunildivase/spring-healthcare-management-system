package com.healthcareApp.repository;

import com.healthcareApp.model.Appointment;
import com.healthcareApp.model.Billing;
import com.healthcareApp.service.ConnectionService;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class BillingRepository {
    private static Connection connection = null;

    public void initConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }



    public boolean createBilling(Billing billing) throws SQLException {

        this.initConnection();

        String query = "INSERT INTO billing(billId,bill,totalBill,personId) VALUES(?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, billing.getBillId());
            preparedStatement.setDouble(2, billing.getBill());
            preparedStatement.setDouble(3, billing.getTotalBill());
            preparedStatement.setInt(4, billing.getPersonId());

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

    public List<Billing> displayBilling() throws SQLException {

        List<Billing> billingList = new ArrayList<>();

        this.initConnection();

        String query = "SELECT * FROM billing";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Billing billing = new Billing(
                        resultSet.getInt("billId"),
                        resultSet.getDouble("bill"),
                        resultSet.getDouble("totalBill"),
                        resultSet.getInt("personId")

                );


                billingList.add(billing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billingList;
    }

    public boolean updateBilling(int billId, double bill) throws SQLException {

        this.initConnection();

        String query = "UPDATE billing SET bill=? WHERE billId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, bill);
            preparedStatement.setInt(2, billId);

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

    public boolean deleteBilling(int billId) throws SQLException {

        this.initConnection();

        String query = "DELETE FROM billing WHERE billId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, billId);

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
