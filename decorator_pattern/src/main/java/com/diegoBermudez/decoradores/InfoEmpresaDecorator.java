package com.diegoBermudez.decoradores;


import com.diegoBermudez.paquete.InterfaceMensaje;

public class InfoEmpresaDecorator extends DecoradorMensaje {

    private String nombreEmpresa;
    private String direccion;
    private String telefono;
    private String emailEmpresa;

    public InfoEmpresaDecorator(InterfaceMensaje Formatomensaje, String nombreEmpresa, String direccion, String telefono, String emailEmpresa) {
        super(Formatomensaje);
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.emailEmpresa = emailEmpresa;
    }

    @Override
    public InterfaceMensaje ProcesarMensaje() {
        Formatomensaje = Formatomensaje.ProcesarMensaje();
        Formatomensaje = agregarDatosEmpresa();
        return Formatomensaje;
    }

    private InterfaceMensaje agregarDatosEmpresa() {
        String contenido = Formatomensaje.getContenido();

        String bodyCloseTag = "</soapenv:Body>";
        int bodyCloseIndex = contenido.indexOf(bodyCloseTag);

        if (bodyCloseIndex != -1) {
            String datosEmpresa = "<footer>\n"
                    + "   <nombreEmpresa>" + nombreEmpresa + "</nombreEmpresa>\n"
                    + "   <direccion>" + direccion + "</direccion>\n"
                    + "   <telefono>" + telefono + "</telefono>\n"
                    + "   <emailEmpresa>" + emailEmpresa + "</emailEmpresa>\n"
                    + "</footer>\n";

            contenido = contenido.substring(0, bodyCloseIndex)
                    + datosEmpresa
                    + contenido.substring(bodyCloseIndex);

            Formatomensaje.setContenido(contenido);
        } else {
            throw new RuntimeException("No se encontró el cierre de </soapenv:Body> en el mensaje SOAP");
        }

        return Formatomensaje;
    }
}
