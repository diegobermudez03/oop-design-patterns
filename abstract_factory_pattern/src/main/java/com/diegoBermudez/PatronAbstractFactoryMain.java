package com.diegoBermudez;

import com.diegoBermudez.abstractfactory.bases.IServiciosBasesGenericos;
import com.diegoBermudez.abstractfactory.bases.ServiciosGenericosAbstractFactory;
import com.diegoBermudez.servicios.IServiciosArticulos;
import com.diegoBermudez.servicios.IServiciosEmpleados;

import java.util.Arrays;


public class PatronAbstractFactoryMain {

    public static void main(String[] args) {

        IServiciosBasesGenericos factory = ServiciosGenericosAbstractFactory.createServiceFactory();
        IServiciosEmpleados employeeService = factory.getEmpleados();
        IServiciosArticulos productService = factory.getArticulos();

        System.out.println("Servicio Empleados class > "
                + employeeService.getClass().getCanonicalName());
        System.out.println("Servicio Articulos class  > "
                + productService.getClass().getCanonicalName());

        System.out.println("getEmployee > "
                + Arrays.toString(employeeService.getEmpleados()));
        System.out.println("getProduct  > "
                + Arrays.toString(productService.getArticulos()));

    }

}
