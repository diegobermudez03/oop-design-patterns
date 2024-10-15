package com.diegoBermudez.composicion.productos;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class OrdenVenta{
    private long CodigoOrden;
    private String Cliente;
    private List<Vendible> productos = new ArrayList<Vendible>();

    public OrdenVenta(long CodigoOrden, String Cliente) {
        this.CodigoOrden = CodigoOrden;
        this.Cliente = Cliente;
    }


    public void AgregarProducto(Vendible producto) {
        productos.add(producto);
    }

    public void ImprimirOrdenVenta() {

        final NumberFormat formater = new DecimalFormat("###,##0.00");
        System.out.println("\\\n============================================="
                + "\nCodigo_Orden: " + CodigoOrden + "\nCliente: " + Cliente
                + "\nProductos:\n");
        productos.stream().forEach(System.out::println);
        System.out.println("Total: " + formater.format(getPrecio())
                + "\n=============================================");
    }

    public double getPrecio(){
        return productos.stream()
                .map((vendible)->vendible.getPrecioVenta())
                .reduce(0d, (acum, actual)-> acum+actual);
    }
}