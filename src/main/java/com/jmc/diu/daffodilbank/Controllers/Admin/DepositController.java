package com.jmc.diu.daffodilbank.Controllers.Admin;

import com.jmc.diu.daffodilbank.Models.Client;
import com.jmc.diu.daffodilbank.Models.Model;
import com.jmc.diu.daffodilbank.Views.ClientCellFactory;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DepositController implements Initializable {
    public TextField pAddress_fld;
    public Button search_btn;
    public ListView<Client> result_list_view;
    public TextField amount_fld;
    public Button deposite_btn;

    private Client client;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        search_btn.setOnAction(e -> onClientSearch());
        deposite_btn.setOnAction(e -> onDeposit());
    }

    private void onClientSearch(){
        ObservableList<Client> searchResults = Model.getInstance().searchClient(pAddress_fld.getText());
        result_list_view.setItems(searchResults);
        result_list_view.setCellFactory(e -> new ClientCellFactory());
        client = searchResults.get(0);
    }

    private void onDeposit(){
        double amount = Double.parseDouble(amount_fld.getText());
        double newBalance = amount + client.savingsAccountProperty().get().balanceProperty().get();
        if(amount_fld.getText() != null){
            Model.getInstance().getDatabaseDriver().depositSavings(client.payeeAddressProperty().get(), newBalance);
        }
        emptyFields();
    }

    private void emptyFields(){
        pAddress_fld.setText("");
        amount_fld.setText("");
    }

}
