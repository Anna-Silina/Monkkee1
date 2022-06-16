package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties;

    // Считывание из файла config.properties
    public ConfigReader() {
        BufferedReader reader;
        String propertyFilePath = "src/test/resources/config.properties"; // путь к этому файлу
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties not found at " + propertyFilePath);
        }
    }

    public String getBrowserName() { // метод для взятия имени браузера, через кот запуск
        String browser = properties.getProperty("browser");
        if (browser != null)
            return browser;
        else
            throw new RuntimeException("browser is not specified in config.properties file");
    }
}
