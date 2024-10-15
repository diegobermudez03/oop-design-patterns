package com.diegoBermudez.fintechC;

public class TransactionTypes{

    public boolean creditTransaction(String name, double value) {
        if(value <= 80000 && !name.isEmpty()) return true;
        //here we would place the logic specific for a credit transaction
        return false;
    }
}
