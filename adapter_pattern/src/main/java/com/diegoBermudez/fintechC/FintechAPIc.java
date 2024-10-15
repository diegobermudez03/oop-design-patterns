package com.diegoBermudez.fintechC;

import java.util.function.Function;

public class FintechAPIc {

    public boolean doTransaction(String user, double value, Transaction trans) throws NonAuthorizedException {
        if(trans.transact(user, value)){
            return true;
        }
        throw new NonAuthorizedException();
    }
}
