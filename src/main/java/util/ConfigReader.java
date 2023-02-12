package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {
    private static Properties ms_properties;

    public static Properties initializeProperties() {
        ms_properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
            try {
                ms_properties.load(fileInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return getProperties();
    }
    public static Properties getProperties(){
        return ms_properties;
    }
}
