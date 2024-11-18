package com.jmc.diu.daffodilbank.Models;

import java.sql.*;
import java.time.LocalDate;

public class DatabaseDriver {
    private final Connection conn;

    public DatabaseDriver() {
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:DaffodilBank.db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*----------------------------Client----------------------------------*/
    public ResultSet getClientData(String pAddress, String password) {
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM Clients WHERE PayeeAddress = ? AND Password = ?";
            PreparedStatement pstmt = this.conn.prepareStatement(query);
            pstmt.setString(1, pAddress);
            pstmt.setString(2, password);
            resultSet = pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    /*------------------------------Admin---------------------------------*/
    public ResultSet getAdminData(String username, String password) {
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM Admins WHERE Username = ? AND Password = ?";
            PreparedStatement pstmt = this.conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            resultSet = pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    // Create Client Method
    public void createClient(String name_fld, String last_name_fld, String pAddress, String password, LocalDate date) {
        String query = "INSERT INTO Clients (FirstName, LastName, PayeeAddress, Password, Date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = this.conn.prepareStatement(query)) {
            pstmt.setString(1, name_fld);
            pstmt.setString(2, last_name_fld);
            pstmt.setString(3, pAddress);
            pstmt.setString(4, password);
            pstmt.setString(5, date.toString());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Create Checking Account Method
    public void createCheckingAccount(String owner, String number, double tlimit, double balance) {
        String query = "INSERT INTO CheckingAccounts (Owner, AccountNumber, TransactionLimit, Balance) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = this.conn.prepareStatement(query)) {
            pstmt.setString(1, owner);
            pstmt.setString(2, number);
            pstmt.setDouble(3, tlimit);
            pstmt.setDouble(4, balance);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Create Savings Account Method
    public void createSavingsAccount(String owner, String number, double wlimit, double balance) {
        String query = "INSERT INTO SavingsAccounts (Owner, AccountNumber, WithdrawalLimit, Balance) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = this.conn.prepareStatement(query)) {
            pstmt.setString(1, owner);
            pstmt.setString(2, number);
            pstmt.setDouble(3, wlimit);
            pstmt.setDouble(4, balance);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Get Last Client ID Method
    public int getLastClientsId() {
        int id = 0;
        try {
            String query = "SELECT seq FROM sqlite_sequence WHERE name = 'Clients'";
            Statement statement = this.conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                id = resultSet.getInt("seq");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
}
