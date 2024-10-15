package com.diegoBermudez.af.familiaws;


import com.diegoBermudez.af.GenericGetRequest;
import com.diegoBermudez.servicios.IServiciosArticulos;

public class ImplementacionWSArticulos implements IServiciosArticulos {

    @Override
    public String[] getArticulos() {
        return GenericGetRequest.getRequest("https://taller-factory.downloadablefox.dev/soap/products", DecodeXML.getInstance(), "products");
    }
}
