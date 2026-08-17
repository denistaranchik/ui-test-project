package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {

            if (inputStream == null) {
                throw new RuntimeException("config.properties was not found in resources");
            }
            properties.load(inputStream);

        } catch (IOException e) {
            throw new RuntimeException("Can not download config.properties", e);
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public static String getFirstName() {
        return properties.getProperty("firstName");
    }

    public static String getLastName() {
        return properties.getProperty("lastName");
    }

    public static String getValidEmail() {
        return properties.getProperty("validEmail");
    }

    public static String getInvalidEmail() {
        return properties.getProperty("invalidEmail");
    }

    public static String getValidPassword() {
        return properties.getProperty("validPassword");
    }

    public static String getInvalidPassword() {
        return properties.getProperty("invalidPassword");
    }

    public static String getMaleGender() {
        return properties.getProperty("maleGender");
    }

    public static String getFemaleGender() {
        return properties.getProperty("femaleGender");
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless"));
    }

    public static int getTimeout() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }
}
