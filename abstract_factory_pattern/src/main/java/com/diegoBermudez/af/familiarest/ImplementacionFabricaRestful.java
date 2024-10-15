package com.diegoBermudez.af.familiarest;


import com.diegoBermudez.bases.IServiciosBasesGenericos;
import com.diegoBermudez.servicios.IServiciosArticulos;
import com.diegoBermudez.servicios.IServiciosEmpleados;

public class ImplementacionFabricaRestful implements IServiciosBasesGenericos {

    @Override
    public IServiciosEmpleados getEmpleados() {
        return new ImplementacionRestEmpleados();
    }

    @Override
    public IServiciosArticulos getArticulos() {
        return new ImplementacionRestArticulos();
    }
}
