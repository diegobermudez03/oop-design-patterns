package com.diegoBermudez.af.familiaws;


import com.diegoBermudez.af.GenericGetRequest;
import com.diegoBermudez.servicios.IServiciosEmpleados;

public class ImplementacionWSEmpleados  implements IServiciosEmpleados {

    @Override
    public String[] getEmpleados() {
        return GenericGetRequest.getRequest("https://taller-factory.downloadablefox.dev/soap/employees", DecodeXML.getInstance(), "employees");
    }
}
