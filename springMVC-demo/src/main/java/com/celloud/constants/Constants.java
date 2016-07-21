package com.celloud.constants;

import java.io.IOException;
import java.util.Properties;

public class Constants {
    private final static String SYSTEM_PROPERTY_PATH = "system.properties";
    private static Properties properties = getProperties();

    private static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(Constants.class.getClassLoader().getResourceAsStream(SYSTEM_PROPERTY_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
