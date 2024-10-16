package com.diegoBermudez.implementacion;


import com.diegoBermudez.IntAdaptador;
import com.diegoBermudez.utilidades.UtilidadesAcceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;



public class AdaptadorMysql implements IntAdaptador {

    private static final String DB_PROPERTIES = "Propiedades/DatosMySQL.properties";

    //Propiedades del archivo de configuraciòn para Mysql
    private static final String DB_NAME_PROP = "dbname";
    private static final String DB_HOST_PROP = "host";
    private static final String DB_PASSWORD_PROP = "password";
    private static final String DB_PORT_PROP = "port";
    private static final String DB_USER_PROP = "user";

    static {
        //Bloque para registrar el Driver de MySQL
        try {
            new com.mysql.cj.jdbc.Driver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        try {
            String connectionString = createConnectionString();
            Connection connection = DriverManager.getConnection(connectionString);
            System.out.println("Connection class ==> " + connection.getClass().getName());
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String createConnectionString() {
        Properties prop = UtilidadesAcceso.loadProperty(DB_PROPERTIES);
        String host = prop.getProperty(DB_HOST_PROP);
        String port = prop.getProperty(DB_PORT_PROP);
        String db = prop.getProperty(DB_NAME_PROP);
        String user = prop.getProperty(DB_USER_PROP);
        String password = prop.getProperty(DB_PASSWORD_PROP);

        String connectionString = "jdbc:mysql://" + host + ":" + port + "/" + db + "?user=" + user + "&password=" + password;
        System.out.println("ConnectionString ==> " + connectionString);
        return connectionString;
    }

}
