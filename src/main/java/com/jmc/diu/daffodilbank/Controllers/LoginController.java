package com.jmc.diu.daffodilbank.Controllers;

import com.jmc.diu.daffodilbank.Models.Model;
import com.jmc.diu.daffodilbank.Views.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public Text account_number_lbl;
    public TextField account_number_fld;
    public Text password_lbl;
    public TextField password_fld;
    public Button login_btn;
    public Label error_lbl;
    public ChoiceBox<AccountType> choicebox_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choicebox_lbl.setItems(FXCollections.observableArrayList(AccountType.CLIENT, AccountType.ADMIN));
        choicebox_lbl.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        choicebox_lbl.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLoginAccountType(choicebox_lbl.getValue()));
        login_btn.setOnAction(event -> onLogin());
    }

    private void onLogin(){
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        if(Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CLIENT){
            Model.getInstance().getViewFactory().showClientWindow();
        }else{
            Model.getInstance().getViewFactory().showAdminWindow();
        }
    }
}
