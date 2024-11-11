package com.jmc.diu.daffodilbank.Controllers.Admin;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateClientController implements Initializable {

    public TextField name_fld;
    public TextField last_name_fld;
    public TextField password_fld;
    public CheckBox payee_ck;
    public Label sv_fld;
    public CheckBox ac_ck;
    public TextField checking_fld;
    public CheckBox sv_account;
    public TextField sv_account_blc_fld;
    public Button create_btn;
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
