package com.jmc.diu.daffodilbank.Views;

import com.jmc.diu.daffodilbank.Controllers.Client.ClientController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewFactory {
    // Logger instance
    private static final Logger logger = Logger.getLogger(ViewFactory.class.getName());
    private final StringProperty clientSelectedMenuItem;

    // Dashboard view instance
    private AnchorPane dashboardView;
    private AnchorPane TransactionView;
    private AnchorPane AccountsView;

    // Constructor
//    public ViewFactory(StringProperty clientSelectedMenuItem) {
//        this.clientSelectedMenuItem = clientSelectedMenuItem;
//    }
    public ViewFactory() {
        this.clientSelectedMenuItem = new SimpleStringProperty();
    }

//    client view section
    public StringProperty getClientSelectedMenuItem() {
        return clientSelectedMenuItem;
    }

    // Method to get the Dashboard view
    public AnchorPane getDashboardView() {
        if (dashboardView == null) {
            try {
                // Load the Dashboard view from FXML
                dashboardView = new FXMLLoader(getClass().getResource("/Fxml/Client/Dashboard.fxml")).load();
            } catch (Exception e) {
                // Log the error using Logger
                logger.log(Level.SEVERE, "Error loading Dashboard view", e);
            }
        }
        return dashboardView;
    }

    public AnchorPane getTransactionView() {
        if (TransactionView == null) {
            try{
                TransactionView = new FXMLLoader(getClass().getResource("/Fxml/Client/Transcations.fxml")).load();
            }catch (Exception e){
                logger.log(Level.SEVERE, "Error loading Transaction view", e);
            }
        }
        return TransactionView;
    }

    public AnchorPane getAccountsView() {
        if (AccountsView == null) {
            try{
                AccountsView = new FXMLLoader(getClass().getResource("/Fxml/Client/Accounts.fxml")).load();
            }catch (Exception e){
                logger.log(Level.SEVERE, "Error loading Account view", e);
            }
        }
        return AccountsView;
    }

    // Method to show the Login window
    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }

    // Private method to create a new Stage
    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            // Load the scene from FXML
            scene = new Scene(loader.load());
        } catch (Exception e) {
            // Log the error using Logger
            logger.log(Level.SEVERE, "Error creating stage", e);
        }

        // Create a new Stage and set the scene
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Daffodil Bank");
        stage.show();
    }

    // Method to show the Client window
    public void showClientWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/Client.fxml"));

        // Set the controller for the Client window
        ClientController clientController = new ClientController();
        loader.setController(clientController);

        // Create the stage for the Client window
        createStage(loader);
    }
}
