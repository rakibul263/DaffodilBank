package com.jmc.diu.daffodilbank.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class SavingsAccount extends Account {
    private final DoubleProperty withdrawalLimit;

    public SavingsAccount(String owner, String accountNumber, Double balance, double withdrawalLimit) {
        super(owner, accountNumber, balance);
        this.withdrawalLimit = new SimpleDoubleProperty(this, "withdrawal Limit", withdrawalLimit);
    }

    public DoubleProperty withdrawalLimitProperty() {return withdrawalLimit; }
}
