package com.diegoBermudez.abstractfactory.bases;


import com.diegoBermudez.servicios.IServiciosArticulos;
import com.diegoBermudez.servicios.IServiciosEmpleados;

public interface IServiciosBasesGenericos {
    public IServiciosEmpleados getEmpleados();
    public IServiciosArticulos getArticulos();
}
