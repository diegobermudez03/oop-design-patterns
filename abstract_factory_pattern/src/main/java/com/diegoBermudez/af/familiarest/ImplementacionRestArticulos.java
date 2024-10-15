package com.diegoBermudez.af.familiarest;


import com.diegoBermudez.servicios.IServiciosArticulos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;

public class ImplementacionRestArticulos implements IServiciosArticulos {

    private static final String[] ARTICULOS = new String[]{"Disco Duro", "Teclados", "Mouse"};

    @Override
    public String[] getArticulos() {
        try{
            URL url = new URL("https://taller-factory.downloadablefox.dev/rest/employees");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if(responseCode == 200){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer accum = new StringBuffer();
                String line;

                while((line = in.readLine()) != null){
                    accum.append(line);
                }
                in.close();
                System.out.println(accum);
            }
;        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
