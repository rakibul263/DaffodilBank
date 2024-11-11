package com.jmc.diu.daffodilbank.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountController implements Initializable {

    public Label checking_account_number;
    public Label transaction_limit;
    public Label check_account_date;
    public Label check_balance;
    public Label sv_acc_number;
    public Label sv_limit;
    public Label sv_date;
    public Label sv_balance;
    public TextField ammount_to_sv;
    public Button transfer_to_sv_btn;
    public TextField account_to_sv;
    public Button transfer_to_ck_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
