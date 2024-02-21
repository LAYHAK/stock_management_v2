package file.demo.serializedemo;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static void writeFile(Object object, String fileLocation) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileLocation, true))) {
            objectOutputStream.writeObject(object);
            System.out.println("Successfully Write a file");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        Person person = new Person();
        Scanner input = new Scanner(System.in);
//        person.inputData(input);
//        person.readData();
        //read object to file
        Worker worker = new Worker("Jame", "Male", 18, new Address("p", "p", "p", "p", "p"), 12, 10, 10);
        String fileLocation = "./mydata/worker.serialized";
        writeFile(worker, fileLocation);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileLocation))) {
            worker = (Worker) objectInputStream.readObject();
            worker.readData();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
