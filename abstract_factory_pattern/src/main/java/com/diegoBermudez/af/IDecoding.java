package com.diegoBermudez.af;

@FunctionalInterface
public interface IDecoding {
    String[] decode(String encoded, String attribute);
}
