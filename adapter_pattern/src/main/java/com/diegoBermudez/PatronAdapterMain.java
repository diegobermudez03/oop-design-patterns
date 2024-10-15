package com.diegoBermudez;


import com.diegoBermudez.implementacion.*;

public class PatronAdapterMain {

    public static void main(String[] args) {

        FintechSolicitudCredito request = new FintechSolicitudCredito();
        request.setCliente("Cristiano Ronaldo");
        request.setValor(1000000);

        InterfaceFintechAdaptador FinancieraB = new AdaptadorFitechB();
        FintechCreditoRespuesta FBresponse = FinancieraB.EnvioSolicitudCredito(request);
        System.out.println("Resultado aprobación Financiera <<B>>: > " + FBresponse.isAprobacion() + "\n");

        if (FBresponse.isAprobacion()) {
            System.out.println("Felicitaciones!!!!!, la Financiera <<B>> aprobó su solicitud de crédito." + "\n");
        }
        else
        {
            System.out.println("Lo sentimos, la Financiera <<B>> no aprobó su crédito");
        }



        InterfaceFintechAdaptador FinancieraA = new AdaptadorFintechA();
        FintechCreditoRespuesta FAresponse = FinancieraA.EnvioSolicitudCredito(request);
        System.out.println("Resultado aprobación Financiera <<A>>: > " + FAresponse.isAprobacion() + "\n");

        if (FAresponse.isAprobacion()) {
            System.out.println("Felicitaciones!!!!!, la Financiera <<A>> aprobó su solicitud de crédito.");
        }
        else
        {
            System.out.println("Lo sentimos, la Financiera <<A>> no aprobó su crédito");
        }

        InterfaceFintechAdaptador financieraC = new AdaptadorFintechC();
        FintechCreditoRespuesta fCResponse = financieraC.EnvioSolicitudCredito(request);
        System.out.println("Resultado aprobación Financiera <<C>>: > " + fCResponse.isAprobacion() + "\n");

        if (fCResponse.isAprobacion()) {
            System.out.println("Felicitaciones!!!!!, la Financiera <<C>> aprobó su solicitud de crédito.");
        }
        else
        {
            System.out.println("Lo sentimos, la Financiera <<C>> no aprobó su crédito");
        }

    }

}