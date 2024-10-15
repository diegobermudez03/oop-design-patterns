package com.diegoBermudez.transferencia.datos;

public class Programa {

    private String programName;
    private int semestersAmount;

    public Programa(String programName, int semestersAmount){
        this.programName = programName;
        this.semestersAmount = semestersAmount;
    }
    String getName(){
        return  this.programName;
    }
    int getSemesters(){
        return this.semestersAmount;
    }
}
