package com.diegoBermudez.composicion.productos;

public class Nodo implements Vendible{

    private Vendible producto;
    private int cantidad;

    public Nodo(Vendible producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    @Override
    public double getPrecioVenta(){
        return producto.getPrecioVenta() *cantidad;
    }

    @Override
    public String getNombre() {
        return producto.getNombre();
    }

    @Override
    public String toString(){
        return "cantidad: "  + cantidad +  " total: $" + getPrecioVenta() + "  de " + producto;
    }
}