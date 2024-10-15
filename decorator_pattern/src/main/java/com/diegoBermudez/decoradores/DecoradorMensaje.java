package com.diegoBermudez.decoradores;


import com.diegoBermudez.paquete.InterfaceMensaje;

public abstract class DecoradorMensaje implements InterfaceMensaje {
    protected InterfaceMensaje Formatomensaje;

    public DecoradorMensaje(InterfaceMensaje mensaje) {
        this.Formatomensaje = mensaje;
    }

    @Override
    public String getContenido() {
        return Formatomensaje.getContenido();
    }

    @Override
    public void setContenido(String contenido) {
        Formatomensaje.setContenido(contenido);
    }
}