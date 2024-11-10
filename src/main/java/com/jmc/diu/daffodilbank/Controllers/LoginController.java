package com.jmc.diu.daffodilbank.Controllers;

import com.jmc.diu.daffodilbank.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public Text account_number_lbl;
    public TextField account_number_fld;
    public Text password_lbl;
    public TextField password_fld;
    public Button login_btn;
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_btn.setOnAction(event->Model.getInstance().getViewFactory().showClientWindow());
    }
}
