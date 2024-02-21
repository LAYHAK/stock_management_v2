package file.demo;

import file.demo.utils.FileUtils;

import java.util.Properties;

public class PropertyMain {
    public static void main(String[] args) {
        Properties properties = FileUtils.loadPropertiesFile("src/application.properties");
        System.out.println("Username is:" + properties.getProperty("username"));
        System.out.println("Username is:" + properties.getProperty("password"));
    }
}
