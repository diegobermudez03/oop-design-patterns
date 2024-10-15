package com.diegoBermudez.decoradores;



import com.diegoBermudez.paquete.ContenidoMensaje;
import com.diegoBermudez.paquete.InterfaceMensaje;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.ByteArrayOutputStream;

public class FormatoDecoradorXML extends DecoradorMensaje {

    public FormatoDecoradorXML(InterfaceMensaje Formatomensaje) {
        super(Formatomensaje);
    }

    @Override
    public InterfaceMensaje ProcesarMensaje() {
        Formatomensaje = Formatomensaje.ProcesarMensaje();
        Formatomensaje = xmlMessage();
        return Formatomensaje;
    }

    private InterfaceMensaje xmlMessage() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            xmlMapper.writeValue(output, Formatomensaje);

            return new ContenidoMensaje(new String(output.toByteArray()));

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error de conversion al formato XML");
        }
    }
}
