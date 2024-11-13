package com.jmc.diu.daffodilbank.Models;

import java.sql.*;

public class DatabaseDriver {
    private final Connection conn;/**/
    public DatabaseDriver() {
        try{
            this.conn = DriverManager.getConnection("jdbc:sqlite:DaffodilBank.db");

        } catch (SQLException e) {
            throw new RuntimeException(e);
//            e.printStackTrace();
        }

    }

    /*----------------------------Client----------------------------------*/
    public ResultSet getClientData(String pAddress, String password){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress='"+pAddress+"' AND Password = '"+password+"';");
        }catch (SQLException e){
//            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    /*------------------------------Admin---------------------------------*/
    public ResultSet getAdminData(String username, String password){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Admins WHERE Username='"+username+"' AND Password='"+password+"';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

}
