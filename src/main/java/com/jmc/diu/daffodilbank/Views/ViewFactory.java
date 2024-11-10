package com.jmc.diu.daffodilbank.Views;

import com.jmc.diu.daffodilbank.Controllers.Client.ClientController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewFactory {
    // Logger instance
    private static final Logger logger = Logger.getLogger(ViewFactory.class.getName());

    // Dashboard view instance
    private AnchorPane dashboardView;

    // Constructor
    public ViewFactory() {}

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
