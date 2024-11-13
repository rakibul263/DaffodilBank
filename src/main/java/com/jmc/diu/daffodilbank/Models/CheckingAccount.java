package com.jmc.diu.daffodilbank.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CheckingAccount extends Account {
    private final IntegerProperty transactionLimit;

    public CheckingAccount(String owner, String accountNumber, double balance, int tlimit){
        super(owner, accountNumber, balance);
        this.transactionLimit = new SimpleIntegerProperty(tlimit);
    }

    public IntegerProperty transactionLimitProp() {return transactionLimit;}
}
