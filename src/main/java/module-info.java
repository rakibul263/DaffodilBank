module com.jmc.diu.daffodilbank {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    opens com.jmc.diu.daffodilbank to javafx.fxml;
    exports com.jmc.diu.daffodilbank;
    exports com.jmc.diu.daffodilbank.Controllers;
    exports com.jmc.diu.daffodilbank.Controllers.Admin;
    exports com.jmc.diu.daffodilbank.Controllers.Client;
    exports com.jmc.diu.daffodilbank.Models;
    exports com.jmc.diu.daffodilbank.Views ;
}
