package com.jmc.diu.daffodilbank.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public Text user_name;
    public Label login_date;
    public Label checking_balance;
    public Label checking_account_number;
    public Label savings_bal;
    public Label saving_num;
    public Label income_lbl;
    public Label expence_lbl;
    public ListView transaction_listview;
    public TextField payee_field;
    public TextField Password_field;
    public TextArea messege_fleld;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
