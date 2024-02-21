package file.demo.serializedemo;

import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable {
    Address address;
    private String name;
    private String gender;
    private int age;

    public Person() {
        address = new Address();
    }

    public Person(String name, String gender, int age, Address address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public Person inputData(Scanner input) {
        System.out.println("Enter Name:");
        name = input.nextLine();
        System.out.println("Enter Gender:");
        gender = input.nextLine();
        System.out.println("Enter Age:");
        age = Integer.parseInt(input.nextLine());
        address.addAddress(input);
        return this;
    }

    public void readData() {
        System.out.println("=".repeat(50));
        System.out.println("Name is " + name);
        System.out.println("Gender is " + gender);
        System.out.println("Age is " + age);
        System.out.println("Address is " + address);
        System.out.println("=".repeat(50));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
