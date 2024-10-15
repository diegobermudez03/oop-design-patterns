package com.diegoBermudez;

import com.diegoBermudez.implementacion.AdaptadorMysql;
import com.diegoBermudez.implementacion.AdaptadorPostgresql;
import com.diegoBermudez.utilidades.UtilidadesAcceso;

import java.util.Properties;


public class FactoryBaseDatos {

    private static final String DB_FACTORY_PROPERTY_URL = "Propiedades/ConfiguracionFactory.properties";
    private static final String DEFAULT_DB_CLASS_PROP = "defaultDBClass";

    public static IntAdaptador getDBadapter(TiposBD dbType) {
        switch (dbType) {
            case MySQL:
                return new AdaptadorMysql();
            case POstgresql:
                return new AdaptadorPostgresql();
            default:
                throw new IllegalArgumentException("Not supported");
        }
    }

    public static IntAdaptador getDefaultDBAdapter() {
        try {
            Properties prop = UtilidadesAcceso.loadProperty(DB_FACTORY_PROPERTY_URL);
            String defaultDBClass = prop.getProperty(DEFAULT_DB_CLASS_PROP);
            System.out.println("DefaultDBClass ==> " + defaultDBClass);
            return (IntAdaptador) Class.forName(defaultDBClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
