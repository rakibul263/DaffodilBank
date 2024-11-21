package com.jmc.diu.daffodilbank.Controllers.Admin;

import com.jmc.diu.daffodilbank.Models.Model;
import com.jmc.diu.daffodilbank.Views.AdminMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button create_client_btn;
    public Button clients_btn;
    public Button deposit_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        create_client_btn.setOnAction(event -> onCreateClient());
        clients_btn.setOnAction(event -> onClients());
        deposit_btn.setOnAction(event -> onDeposit());
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
        //Get Stage
        Stage stage = (Stage) clients_btn.getScene().getWindow();
        //close the admin window
        Model.getInstance().getViewFactory().closeStage(stage);
        //show login window
        Model.getInstance().getViewFactory().showLoginWindow();
        //login flag false
        Model.getInstance().setAdminLoginSuccessFlag(false);
    }
}
