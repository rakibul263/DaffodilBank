package com.jmc.diu.daffodilbank.Controllers.Client;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionCellController  implements Initializable {
    public FontAwesomeIconView in_icon;
    public FontAwesomeIconView out_icon;
    public Label tras_date_lbl;
    public Label sender_lbl;
    public Label rcvr_lbl;
    public Label amount_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
