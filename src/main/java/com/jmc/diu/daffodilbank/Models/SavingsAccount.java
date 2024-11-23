package com.jmc.diu.daffodilbank.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class SavingsAccount extends Account {
    //The withdrawal limit
    private final DoubleProperty withdrawalLimit;

    public SavingsAccount(String owner, String accountNumber, double balance, double withdrawalLimit) {
        super(owner, accountNumber, balance);
        this.withdrawalLimit = new SimpleDoubleProperty(this,"withdrawal Limit",withdrawalLimit);
    }

    public DoubleProperty withdrawalLimitProp() {
        return withdrawalLimit;
    }

    public String toString(){
        return accountNumberProperty().get();
    }

}
