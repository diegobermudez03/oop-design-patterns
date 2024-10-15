package com.diegoBermudez.iteratorPattern;


public interface ProfileIterator<T> {
    T getNext();
    boolean hasNext();
}
