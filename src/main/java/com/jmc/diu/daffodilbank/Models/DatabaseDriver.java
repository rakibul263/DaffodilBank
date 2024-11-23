package com.jmc.diu.daffodilbank.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class DatabaseDriver {
    private Connection conn;

    public DatabaseDriver() {
        try{
            this.conn = DriverManager.getConnection("jdbc:sqlite:DaffodilBank.db");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /*Client Section*/
    public ResultSet getClientData(String pAddress, String password){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress='"+pAddress+"' AND Password = '"+password+"';");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }
    /*Admin Section*/

    public ResultSet getAdminData(String username, String password){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Admins WHERE Username='"+username+"' AND Password='"+password+"';");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void createClient(String fName, String lName, String pAddress, String password, LocalDate date){
        Statement statement;
        try{
            statement = this.conn.createStatement();
            statement.executeQuery("INSERT INTO " +
                    "Clients (FirstName, LastName, PayeeAddress, Password, Date)" +
                     "VALUES ('"+fName+"','"+lName+"', '"+pAddress+"', '"+password+"', '" + date.toString()+"')");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createCheckingAccount(String owner, String number, double tLimit, double balance){
        Statement statement;
        try{
            statement = this.conn.createStatement();
            statement.executeUpdate("INSERT INTO "+
                    "CheckingAccounts (Owner, AccountNumber, TransactionLimit, Balance)"+
                    "VALUES ('"+owner+"', '"+number+"', "+tLimit+", "+balance+")");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void createSavingsAccount(String owner, String number, double wLimit, double balance){
        Statement statement;
        try{
            statement = this.conn.createStatement();
            statement.executeUpdate("INSERT INTO "+
                    "SavingsAccounts (Owner, AccountNumber, WithdrawalLimit, Balance)"+
                    "VALUES ('"+owner+"', '"+number+"', "+wLimit+", "+balance+")");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ResultSet getAllClientsData(){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients;");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet searchClient(String pAddress){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress = '"+pAddress+"';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void depositSavings(String pAddress, double amount){
        Statement statement;
        try{
            statement = this.conn.createStatement();
            statement.executeUpdate("UPDATE SAVINGSACCOUNTS SET BALANCE="+amount+" WHERE Owner = '"+pAddress+"';");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /*Utility Section*/

    public int getLastClientsId(){
        Statement statement;
        ResultSet resultSet;
        int id = 0;
        try{
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM sqlite_sequence WHERE name='Clients';");
            id = resultSet.getInt("seq");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public ResultSet getCheckingAccountsData(String pAddress){
        Statement statement;
        ResultSet resultSet = null;

        try{
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM CheckingAccounts WHERE Owner='"+pAddress+"';");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getSavingsAccountsData(String pAddress){
        Statement statement;
        ResultSet resultSet = null;

        try{
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM SavingsAccounts WHERE Owner='"+pAddress+"';");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }
}