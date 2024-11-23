package com.jmc.diu.daffodilbank.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CheckingAccount extends Account {
    private final IntegerProperty transactionLimit;//number of transaction

    public CheckingAccount(String owner, String accountNumber, Double balance, int tLimit){
        super(owner, accountNumber, balance);
        this.transactionLimit = new SimpleIntegerProperty(this, "Transaction Limit", tLimit);
    }

    public IntegerProperty transactionLimitProp() {
        return transactionLimit;
    }

    @Override
    public String toString() {
        return accountNumberProperty().get();
    }
}
