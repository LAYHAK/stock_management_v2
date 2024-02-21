package file.demo;

import file.demo.utils.FileUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your message:");
        String message = input.nextLine();
        System.out.println("Enter your filename");
        String filename = input.nextLine();
        FileUtils.writeTextFile(message, filename, false);

        // ? read file
        FileUtils.readTextFile(filename);
    }
}
