package com.diegoBermudez;


import com.diegoBermudez.decoradores.*;
import com.diegoBermudez.mensajes.MensajeCliente;
import com.diegoBermudez.paquete.InterfaceMensaje;

public class PatronDecoratorMain {

    public static void main(String[] args) {

        MensajeCliente MensajeUsuario = new MensajeCliente(
                "Fabrizio Bolaño", "fbolano@javeriana.edu.co", "99887766");
        System.out.println("Mensaje Original ==> " + MensajeUsuario);

        InterfaceMensaje F1Mensaje = new CifrarMensaje("user", "HG58YZ3CR9123456",
                new InfoEmpresaDecorator(
                        new CredencialesSOAPDecorator(
                            new MensajeSOAP(
                                new FormatoDecoradorXML(MensajeUsuario)
                            ), "user", "HG58YZ3CR9123456"
                    )
                , "Javeriana", "Carrera 7", "3008522437", "jav@javeriana.edu.co")
        ).ProcesarMensaje();


        System.out.println("Mensaje No. 1 =====================================>\n"
                + F1Mensaje.getContenido() + "\n\n");

        InterfaceMensaje F2Mensaje = new CredencialesSOAPDecorator(
                new InfoEmpresaDecorator(
                        new MensajeSOAP(
                            new CifrarMensaje("user", "HG58YZ3CR9123456",
                                new FormatoDecoradorXML(MensajeUsuario)
                            )
                        ),
                        "Javeriana", "Carrera 7", "3008522437", "jav@javeriana.edu.co"
                ), "user", "HG58YZ3CR9123456"
        ).ProcesarMensaje();

        System.out.println("message2 =====================================>\n"
                + F2Mensaje.getContenido() + "\n\n");

        InterfaceMensaje f3Mensaje = new InfoEmpresaDecorator(
                new CredencialesSOAPDecorator(
                        new MensajeSOAP(
                                new FormatoDecoradorXML(MensajeUsuario)
                        )
                        , "juand", "password"
                ), "Javeriana", "Carrera 7", "3008522437", "jav@javeriana.edu.co"
        ).ProcesarMensaje();

        System.out.println("message3 =====================================>\n"
                + f3Mensaje.getContenido() + "\n\n");
    }

}
