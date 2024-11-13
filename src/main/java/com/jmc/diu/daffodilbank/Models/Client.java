package com.jmc.diu.daffodilbank.Models;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDate;

public class Client {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty payeeAddress;
    private final ObjectProperty<LocalDate> dateProperty;

    public Client(String firstName, String lastName, String pAddress, LocalDate date) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.payeeAddress = new SimpleStringProperty(pAddress);
        this.dateProperty = new SimpleObjectProperty<>(date != null ? date : LocalDate.now());
    }

    public StringProperty firstNameProperty() { return firstName; }
    public StringProperty lastNameProperty() { return lastName; }
    public StringProperty payeeAddressProperty() { return payeeAddress; }
    public ObjectProperty<LocalDate> dateProperty() { return dateProperty; }
}
