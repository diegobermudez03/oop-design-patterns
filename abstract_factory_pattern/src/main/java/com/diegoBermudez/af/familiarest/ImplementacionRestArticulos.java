package com.diegoBermudez.af.familiarest;


import com.diegoBermudez.af.GenericGetRequest;
import com.diegoBermudez.servicios.IServiciosArticulos;


public class ImplementacionRestArticulos implements IServiciosArticulos {

    @Override
    public String[] getArticulos() {
        return GenericGetRequest.getRequest("https://taller-factory.downloadablefox.dev/rest/products", DecodeJSON.getInstance(), "products");
    }
}
