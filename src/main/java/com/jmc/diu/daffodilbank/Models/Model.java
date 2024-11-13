package com.jmc.diu.daffodilbank.Models;
import com.jmc.diu.daffodilbank.Views.AccountType;
import com.jmc.diu.daffodilbank.Views.ViewFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
//    private AccountType loginAccountType = AccountType.CLIENT;

    /*client data section*/
    private final Client client;
    private boolean clientLoginSuccessFlag;

    /*admin data section*/
    private boolean adminLoginSuccessFlag;

    private Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        /*client data section*/
        this.clientLoginSuccessFlag = false;
        this.client = new Client("", "", "", LocalDate.now());

        /*admin data section*/
        this.adminLoginSuccessFlag = false;
    }

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() { return viewFactory; }
    public DatabaseDriver getDatabaseDriver() { return databaseDriver; }

    public boolean getClientLoginSuccessFlag() {
        return this.clientLoginSuccessFlag;
    }

    public void setClientLoginSuccessFlag(boolean flag) {
        this.clientLoginSuccessFlag = flag;
    }

    public Client getClient() {
        return this.client;
    }

    public void evaluateClientCred(String pAddress, String password) {
        ResultSet resultSet = databaseDriver.getClientData(pAddress, password);
        try {
            if (resultSet != null && resultSet.isBeforeFirst()) {
                resultSet.next(); // Move to the first row
                this.client.firstNameProperty().set(resultSet.getString("FirstName"));
                this.client.lastNameProperty().set(resultSet.getString("LastName"));
                this.client.payeeAddressProperty().set(resultSet.getString("PayeeAddress"));

                String[] dateParts = resultSet.getString("Date").split("-");
                LocalDate date = LocalDate.of(
                        Integer.parseInt(dateParts[0]),
                        Integer.parseInt(dateParts[1]),
                        Integer.parseInt(dateParts[2])
                );

                this.client.dateProperty().set(date);
                this.clientLoginSuccessFlag = true;
            } else {
                this.clientLoginSuccessFlag = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*-----------------------------admin method------------------------------*/
    public boolean getAdminLoginSuccessFlag() {
        return this.adminLoginSuccessFlag;
    }
    public void setAdminLoginSuccessFlag(boolean adminLoginSuccessFlag) {
        this.adminLoginSuccessFlag = adminLoginSuccessFlag;
    }

    public void evaluateAdminCred(String username, String password) {
        ResultSet resultSet = databaseDriver.getAdminData(username,password);
        try{
            if(resultSet.isBeforeFirst()){
                this.adminLoginSuccessFlag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
