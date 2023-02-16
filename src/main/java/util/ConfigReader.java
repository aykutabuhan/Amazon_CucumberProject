package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties ms_properties;

    static {
        ms_properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
            ms_properties.load(fileInputStream);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(final String propName) {
        return ms_properties.getProperty(propName);
    }
}
