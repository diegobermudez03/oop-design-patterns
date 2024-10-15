package com.diegoBermudez.decoradores;


import com.diegoBermudez.paquete.InterfaceMensaje;

public class CredencialesSOAPDecorator extends DecoradorMensaje {

    private String usuario;
    private String password;

    public CredencialesSOAPDecorator(InterfaceMensaje Formatomensaje, String usuario, String password) {
        super(Formatomensaje);
        this.usuario = usuario;
        this.password = password;
    }

    @Override
    public InterfaceMensaje ProcesarMensaje() {
        Formatomensaje = Formatomensaje.ProcesarMensaje();
        Formatomensaje = agregarCredenciales();
        return Formatomensaje;
    }

    private InterfaceMensaje agregarCredenciales() {
        String contenido = Formatomensaje.getContenido();
        String headerTag = "<soapenv:Header/>";
        int headerIndex = contenido.indexOf(headerTag);

        if (headerIndex != -1) {
            String credenciales = "\n       <ser:credentials>\n"
                    + "         <usuario>" + usuario + "</usuario>\n"
                    + "         <password>" + password + "</password>\n"
                    + "     </ser:credentials>\n";

            contenido = contenido.substring(0, headerIndex + headerTag.length()-2)+ ">"
                    + credenciales
                    + "   </soapenv:Header>"
                    + contenido.substring(headerIndex + headerTag.length());

            Formatomensaje.setContenido(contenido);
        } else {
            throw new RuntimeException("No se encontró el <soapenv:Header> en el mensaje SOAP");
        }

        return Formatomensaje;
    }
}
