package mypackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by sergei on 08.04.2015.
 */
public class PropertiesMy {

    Properties properties;

    public PropertiesMy() {
         properties = new Properties();
        String propFileName = "resource//config.properties";
        InputStream inputStream = getClass().getResourceAsStream(propFileName);
        try {
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Properties getProp(){

        return properties;
    }
}
