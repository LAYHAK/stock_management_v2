package file.demo.utils;

import java.io.*;
import java.util.Properties;

public class FileUtils {
    public static void writeTextFile(String data, String fileLocation, boolean isAppend) {
        //Check to see if the file exist or not
        File file = new File(fileLocation).getParentFile();
        if (file.exists()) {
            System.out.println("File already exist");
        } else {
            boolean result = file.mkdir();
            System.out.println("Result is " + result);
            System.out.println("Create a directory");
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileLocation, isAppend))) {
            bufferedWriter.write(data);
            System.out.println("Created Successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void readTextFile(String filename) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                System.out.println(data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Properties loadPropertiesFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Properties properties = new Properties();
            properties.load(reader);
            return properties;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
