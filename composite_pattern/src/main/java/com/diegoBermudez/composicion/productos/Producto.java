package com.diegoBermudez.composicion.productos;

public class Producto  implements  Vendible{
    private String nombre;
    private double precio;
    protected double tasaImpuesto;
    private String marca;

    public Producto(String nombre, double precio, String marca, double tasaImpuesto) {
        this.nombre = nombre;
        this.precio = precio;
        this.tasaImpuesto = tasaImpuesto;
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioVenta() {
        return precio + (tasaImpuesto*precio);
    }

    @Override
    public String toString(){
        return nombre + "  precio: $" + precio + "    Impuesto: "+ tasaImpuesto + "    total unidad: $" + getPrecioVenta();
    }

}