package com.jmc.diu.daffodilbank.Controllers.Admin;

import com.jmc.diu.daffodilbank.Models.Model;
import com.jmc.diu.daffodilbank.Views.AdminMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button create_client;
    public Button client_btn;
    public Button deposite_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners(){
        create_client.setOnAction(event -> onCreateClient());
        client_btn.setOnAction(event -> onClients());
        deposite_btn.setOnAction(event -> onDeposit());
        logout_btn.setOnAction(event -> onLogout());
    }

    private void onCreateClient(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CREATE_CLIENT);
    }

    private void onClients(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CLIENTS);
    }

    private void onDeposit(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.DEPOSIT);
    }

    private void onLogout(){
        //get stage
        Stage stage = (Stage) client_btn.getScene().getWindow();
        //close the Admin window
        Model.getInstance().getViewFactory().closeStage(stage);
        //show login window
        Model.getInstance().getViewFactory().showLoginWindow();
        //show client login successful flag is false
        Model.getInstance().setAdminLoginSuccessFlag(false);
    }

}