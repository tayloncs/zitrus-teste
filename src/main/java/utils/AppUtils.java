package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppUtils {
    public static String getPropertyValue(String propertyName) {
        Properties properties = new Properties();
        String value = "";

        try (InputStream inputStream = AppUtils.class.getClassLoader().getResourceAsStream("application.yaml")) {
            if (inputStream != null) {
                properties.load(inputStream);
                value = properties.getProperty(propertyName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}

