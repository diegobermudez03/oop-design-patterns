package com.diegoBermudez.af.familiarest;


import com.diegoBermudez.af.GenericGetRequest;
import com.diegoBermudez.servicios.IServiciosEmpleados;

public class ImplementacionRestEmpleados  implements IServiciosEmpleados {

    @Override
    public String[] getEmpleados() {
        return GenericGetRequest.getRequest("https://taller-factory.downloadablefox.dev/rest/employees", DecodeJSON.getInstance(), "employees");
    }
}
