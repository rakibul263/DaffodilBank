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
        choicebox_lbl.valueProperty().addListener(observable -> setAcc_selector() );
        login_btn.setOnAction(event -> onLogin());
    }

    private void onLogin(){
        Stage stage = (Stage) error_lbl.getScene().getWindow();
//        Model.getInstance().getViewFactory().closeStage(stage);
        if(Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CLIENT){
//            Model.getInstance().getViewFactory().showClientWindow();
            Model.getInstance().evaluateClientCred(account_number_fld.getText(), password_fld.getText());
            if(Model.getInstance().getClientLoginSuccessFlag()){
                Model.getInstance().getViewFactory().showClientWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            }else{
                account_number_lbl.setText("");
                password_lbl.setText("");
                error_lbl.setText("No such login Credentials");
            }
        }else{
//            Model.getInstance().getViewFactory().showAdminWindow();
            Model.getInstance().evaluateAdminCred(account_number_fld.getText(), password_fld.getText());
            if(Model.getInstance().getAdminLoginSuccessFlag()){
                Model.getInstance().getViewFactory().showAdminWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            }else{
                account_number_lbl.setText("");
                password_lbl.setText("");
                error_lbl.setText("No such login Credentials");
            }
        }
    }
    private void setAcc_selector(){
        Model.getInstance().getViewFactory().setLoginAccountType(choicebox_lbl.getValue());
        //change payee address label accordingly
        if(choicebox_lbl.getValue() == AccountType.ADMIN){
//            Model.getInstance().getViewFactory().showAdminWindow();
            account_number_lbl.setText("Username:");
            password_lbl.setText("Password:");
        }else{
            account_number_lbl.setText("Payee Address:");
            password_lbl.setText("Password:");
        }

    }
}
