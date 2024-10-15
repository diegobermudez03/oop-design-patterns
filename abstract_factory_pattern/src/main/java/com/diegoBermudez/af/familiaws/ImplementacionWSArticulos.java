package com.diegoBermudez.af.familiaws;


import com.diegoBermudez.servicios.IServiciosArticulos;

public class ImplementacionWSArticulos implements IServiciosArticulos {
    private static final String[] ARTICULOS = new String[]{"Disco Duro", "Teclados", "Mouse"};

    @Override
    public String[] getArticulos() {
        System.out.println("Tipo de Servicio: WebServices");
        return ARTICULOS;

    }
}
