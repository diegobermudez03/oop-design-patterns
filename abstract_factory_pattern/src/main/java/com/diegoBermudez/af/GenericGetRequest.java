package com.diegoBermudez.af;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GenericGetRequest {

    public static String[] getRequest(String urlRequest, IDecoding decoding, String attribute) {
        try{
            URL url = new URL(urlRequest);

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
                return decoding.decode(accum.toString(), attribute);
            }
            ;        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
