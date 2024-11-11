package com.jmc.diu.daffodilbank.Views;

import com.jmc.diu.daffodilbank.Controllers.Admin.AdminController;
import com.jmc.diu.daffodilbank.Controllers.Client.ClientController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewFactory {
    private AccountType loginAccountType;
    // Logger instance
    private static final Logger logger = Logger.getLogger(ViewFactory.class.getName());
    private final ObjectProperty<ClientMenuOptions> clientSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane transactionsView;
    private AnchorPane accountsView;

    /*Admin section*/
    private final ObjectProperty<AdminMenuOptions> adminSelectedMenuItem;
    private AnchorPane createClientView;

    public ViewFactory() {
        this.loginAccountType = AccountType.CLIENT;
        this.clientSelectedMenuItem = new SimpleObjectProperty<>();
        this.adminSelectedMenuItem = new SimpleObjectProperty<>();
    }

    //seter
    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    //geter
    public AccountType getLoginAccountType() {
        return loginAccountType;
    }


    /*----------------------------------client view-----------------------------*/

    public ObjectProperty<ClientMenuOptions> getClientSelectedMenuItem() {
        return clientSelectedMenuItem;
    }

    public AnchorPane getDashboardView() {
        if (dashboardView == null) {
            try {
                dashboardView = new FXMLLoader(getClass().getResource("/Fxml/Client/Dashboard.fxml")).load();
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error loading Dashboard view", e);
            }
        }
        return dashboardView;
    }

    public AnchorPane getTransactionView() {
        if (transactionsView == null) {
            try{
                transactionsView = new FXMLLoader(getClass().getResource("/Fxml/Client/Transcations.fxml")).load();
            }catch (Exception e){
                logger.log(Level.SEVERE, "Error loading Transaction view", e);
            }
        }
        return transactionsView;
    }

    public AnchorPane getAccountsView() {
        if (accountsView == null) {
            try{
                accountsView = new FXMLLoader(getClass().getResource("/Fxml/Client/Accounts.fxml")).load();
            }catch (Exception e){
                logger.log(Level.SEVERE, "Error loading Account view", e);
            }
        }
        return accountsView;
    }

    public void showClientWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/Client.fxml"));
        ClientController clientController = new ClientController();
        loader.setController(clientController);
        createStage(loader);
    }




    /*-------------------------admin view section--------------------------*/

    public AnchorPane getCreateClientView() {
        if (createClientView == null) {
            try{
                createClientView = new FXMLLoader(getClass().getResource("/Fxml/Admin/CreateClient")).load();
            }catch (Exception e){
                logger.log(Level.SEVERE, "Error loading Client view", e);
            }
        }
        return createClientView;
    }


    public ObjectProperty<AdminMenuOptions> getAdminSelectedMenuItem() {
        return adminSelectedMenuItem;
    }

    public void showAdminWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/Admin.fxml"));
        AdminController controller = new AdminController();
        loader.setController(controller);
        createStage(loader);
    }

    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error creating stage", e);
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Daffodil Bank");
        stage.show();
    }

    public void closeStage(Stage stage) {
        stage.close();
    }

}
