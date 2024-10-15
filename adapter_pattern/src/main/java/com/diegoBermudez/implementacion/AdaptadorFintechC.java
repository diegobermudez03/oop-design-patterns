package com.diegoBermudez.implementacion;


import com.diegoBermudez.fintechC.FintechAPIc;
import com.diegoBermudez.fintechC.NonAuthorizedException;
import com.diegoBermudez.fintechC.TransactionTypes;

public class AdaptadorFintechC implements InterfaceFintechAdaptador{

    @Override
    public FintechCreditoRespuesta EnvioSolicitudCredito(FintechSolicitudCredito request) {
        FintechAPIc api = new FintechAPIc();
        TransactionTypes trans = new TransactionTypes();

        FintechCreditoRespuesta response = new FintechCreditoRespuesta();

        try {
            boolean transResult = api.doTransaction(request.getCliente(), request.getValor(), trans::creditTransaction);
            response.setAprobacion(transResult);
        }
        catch(NonAuthorizedException exc){
            response.setAprobacion(false);
        }

        return response;
    }
}
