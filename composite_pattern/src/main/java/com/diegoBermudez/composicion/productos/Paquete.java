package com.diegoBermudez.composicion.productos;

import java.util.ArrayList;
import java.util.List;

public class Paquete implements Vendible{
    private List<Vendible> productos = new ArrayList<Vendible>();
    private String nombrePaquete;

    public Paquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
    }

    @Override
    public String getNombre() {
        return this.nombrePaquete;
    }

    public void AgregarProducto(Vendible producto) {
        this.productos.add(producto);
    }

    public boolean RemoverProductos(Vendible producto) {
        return this.productos.remove(producto);
    }

    @Override
    public String toString(){
        return "Paquete->" + nombrePaquete + ":" + "\n" +
                productos.stream().map((p)->"     " + p.toString() + "\n").reduce("", (prev, curr)-> prev+curr) +
                "Total paquete: $" + getPrecioVenta() + "\n";
    }

    @Override
    public double getPrecioVenta(){
        return productos.stream()
                .map((vendible)->vendible.getPrecioVenta())
                .reduce(0d, (acum, actual)-> acum+actual);
    }
}