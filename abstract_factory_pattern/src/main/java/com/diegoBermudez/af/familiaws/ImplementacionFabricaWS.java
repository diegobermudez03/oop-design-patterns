package com.diegoBermudez.af.familiaws;


import com.diegoBermudez.bases.IServiciosBasesGenericos;
import com.diegoBermudez.servicios.IServiciosArticulos;
import com.diegoBermudez.servicios.IServiciosEmpleados;

public class ImplementacionFabricaWS implements IServiciosBasesGenericos {
    @Override
    public IServiciosEmpleados getEmpleados() {
        return new ImplementacionWSEmpleados();
    }

    @Override
    public IServiciosArticulos getArticulos() {
        return new ImplementacionWSArticulos();
    }
}
