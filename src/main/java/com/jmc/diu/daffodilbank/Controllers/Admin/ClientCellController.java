package com.jmc.diu.daffodilbank.Controllers.Admin;

import com.jmc.diu.daffodilbank.Models.Client;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientCellController implements Initializable {
    public Label fname_lbl;
    public Label lname_lbl;
    public Label ch_ac_lbl;
    public Label payee_address_lbl;
    public Label date_lbl;
    public Label sv_ac_lbl;
    public Button delete_btn;

    private final Client client;
    public ClientCellController(Client client) {
        this.client = client;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
