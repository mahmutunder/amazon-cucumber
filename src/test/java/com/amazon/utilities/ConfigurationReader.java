package com.amazon.utilities;

import org.openqa.selenium.devtools.v85.io.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    private static FileInputStream file;
    private static Properties properties= new Properties();

    static {
        try {
            file= new FileInputStream("Configuration.properties");
            properties.load(file);
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static String getProperty(String key) {

        return properties.getProperty(key);
    }
}
