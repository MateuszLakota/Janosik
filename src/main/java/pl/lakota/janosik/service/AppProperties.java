package pl.lakota.janosik.service;

import lombok.Getter;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {
    @Getter
    private static final String USERNAME = System.getProperty("user.name");

    private static final Logger LOGGER = Logger.getLogger(AppProperties.class.getName());

    public static Object getPropertiesValue(String propertyKey) {
        Properties properties = new Properties();
        InputStream resourceStream = AppProperties.class.getResourceAsStream("/application.properties");

        try {
            properties.load(resourceStream);
        } catch (IOException exception) {
            LOGGER.error(exception.getMessage(), exception);
        }

        return properties.get(propertyKey);
    }
}
