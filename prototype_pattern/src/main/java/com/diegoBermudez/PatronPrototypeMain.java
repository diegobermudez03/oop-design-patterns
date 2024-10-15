package com.diegoBermudez;


import com.diegoBermudez.implementacion.CatalogoProductos;
import com.diegoBermudez.implementacion.FabricaPrototype;
import com.diegoBermudez.implementacion.ListaPrecios;

public class PatronPrototypeMain {

    public static void main(String[] args) {


        //Creación de la Lista Inicial de Precios

        ListaPrecios listadoEstandar = new ListaPrecios("Lista Estándar de Precios");
        for(int c = 1; c<=5; c++){
            CatalogoProductos item = new CatalogoProductos("Producto " + c, c*2);
            listadoEstandar.addCatalogoItem(item);
        }

        //Segunda lista para clientes mayoristas.
        //Se obtiene del listado estándar con un 10% de descuento.

        FabricaPrototype.addPrototype(listadoEstandar.getListado(), listadoEstandar);

        ListaPrecios listadoPorMayor = (ListaPrecios)
                FabricaPrototype.getPrototype("Lista Estándar de Precios");
        listadoPorMayor.setListado("Listado de Precios al Por Mayor");

        for(CatalogoProductos item : listadoPorMayor.getProductos()){
            item.setPrecioProducto(item.getPrecioProducto()*0.90);
        }
        FabricaPrototype.addPrototype(listadoPorMayor.getListado(), listadoPorMayor);

        //Tercera lista de precios para clientes Especiales.
        //Se obtiene de la listado Mayorista menos un 10%.
        ListaPrecios listadoClientesEspeciales = (ListaPrecios)
                FabricaPrototype.getPrototype("Listado de Precios al Por Mayor");
        listadoClientesEspeciales.setListado("Listado de Precios Clientes Especiales");

        for(CatalogoProductos item : listadoClientesEspeciales.getProductos()){
            item.setPrecioProducto(item.getPrecioProducto()*0.90);
        }


        //Listado con IVA del 19 % sobre los precios del listado estandar
        ListaPrecios iva19 = (ListaPrecios) FabricaPrototype.getPrototype("Lista Estándar de Precios");
        iva19.setListado("IVA de 19%");
        for(CatalogoProductos p : iva19.getProductos()){
            p.setPrecioProducto(Math.round(p.getPrecioProducto()*119.0)/100.0);
        }

        //Listado con IVA del 5% sobre los precios del listado estandar
        ListaPrecios iva5 = (ListaPrecios) FabricaPrototype.getPrototype("Lista Estándar de Precios");
        iva5.setListado("IVA de 5%");
        for(CatalogoProductos p : iva5.getProductos()){
            p.setPrecioProducto(Math.round(p.getPrecioProducto()*105.0)/100.0);
        }

        //Imprimimos las diferentes listas.
        System.out.println(listadoEstandar);
        System.out.println(listadoPorMayor);
        System.out.println(listadoClientesEspeciales);
        System.out.println(iva19);
        System.out.println(iva5);

    }

}