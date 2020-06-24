package org.dog.breed.utility;

import org.dog.breed.contactClass.Constant;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {

    public static Properties fetchApiDetails(String propertyFile) throws IOException {

        FileInputStream file = new FileInputStream(propertyFile);
        Properties prop = new Properties();
        prop.load(file);
        return prop;
    }

    public static String fetchPropertyValue(String key) throws IOException {

        FileInputStream file = new FileInputStream(Constant.WEB_TESTING_ELEMENTS_FILE_PATH);
        Properties prop = new Properties();
        prop.load(file);
        return prop.get(key).toString();
    }

    public static String fetchWebDetails(String key) throws IOException {

        FileInputStream file = new FileInputStream(Constant.WEB_PROPERTY_FILE_PATH);
        Properties prop = new Properties();
        prop.load(file);
        return prop.get(key).toString();
    }


}
