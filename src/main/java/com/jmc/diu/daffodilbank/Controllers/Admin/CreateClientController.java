package com.jmc.diu.daffodilbank.Controllers.Admin;

import com.jmc.diu.daffodilbank.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;

public class CreateClientController implements Initializable {

    public TextField name_fld;
    public TextField last_name_fld;
    public TextField password_fld;
    public CheckBox payee_ck;
    public Label pAddress_lbl;
    public CheckBox ac_ck;
    public TextField checking_fld;
    public CheckBox sv_account;
    public TextField sv_account_blc_fld;
    public Button create_btn;
    public Label error_lbl;

    private String payeeAddress;
    private boolean createCheckingAccountFlag = false;
    private boolean createSavingsAccountFlag = false;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        create_btn.setOnAction(event -> createClient());
        payee_ck.selectedProperty().addListener((observable, oldVal, newVal) -> {
            if(newVal){
                payeeAddress = createPayeeAddress();
                onCreatePayeeAddress();
            }
        });
        ac_ck.selectedProperty().addListener((observable, oldVal, newVal) -> {
            if(newVal){
                createCheckingAccountFlag = true;
            }
        });
        sv_account.selectedProperty().addListener((observable, oldVal, newVal) -> {
            if(newVal){
                createSavingsAccountFlag = true;
            }
        });
    }


    private void createClient(){
        if(createCheckingAccountFlag){
            createAccount("Checking");
        }
        if(createSavingsAccountFlag){
            createAccount("Savings");
        }

        String fName = name_fld.getText();
        String lName = last_name_fld.getText();
        String password = password_fld.getText();
        Model.getInstance().getDatabaseDriver().createClient(fName, lName, payeeAddress, password, LocalDate.now());
        error_lbl.setStyle("-fx-text-fill: blue; -fx-font-size: 1.3em; -fx-font-weight: bold");
        error_lbl.setText("Client Created Successfully!");
        emptyFields();
    }

    private String createPayeeAddress(){
        int id = Model.getInstance().getDatabaseDriver().getLastClientsId() +1;
        char fChar = Character.toLowerCase(name_fld.getText().charAt(0));
        return "@"+fChar+last_name_fld.getText()+id;
    }

    private void createAccount(String accountType) {
        double balance = Double.parseDouble(checking_fld.getText());
        //generate account number;
        String firstSection = "2024";
        String lastSection = Integer.toString((new Random()).nextInt(9999)+1000);
        String accountNumber = firstSection + " " + lastSection;

//        Model.getInstance().getDatabaseDriver().createCheckingAccount(payeeAddress, accountNumber, 10, balance);
        if(accountType.equals("Checking")) {
            Model.getInstance().getDatabaseDriver().createCheckingAccount(payeeAddress, accountNumber, 10, balance);
        }else{
            Model.getInstance().getDatabaseDriver().createSavingsAccount(payeeAddress, accountNumber, 100000, balance);
        }
    }

    private void onCreatePayeeAddress(){
        if(name_fld.getText() != null & last_name_fld.getText() != null){
            pAddress_lbl.setText(payeeAddress);
        }
    }

    private void emptyFields(){
        name_fld.setText("");
        last_name_fld.setText("");
        password_fld.setText("");
        payee_ck.setSelected(false);
        pAddress_lbl.setText("");
        ac_ck.setSelected(false);
        checking_fld.setText("");
        sv_account.setSelected(false);
        sv_account_blc_fld.setText("");
    }

}
