package com.diegoBermudez.fintechC;

@FunctionalInterface
public interface Transaction {

    boolean transact(String name, double value);
}
