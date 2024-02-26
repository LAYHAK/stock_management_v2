package service;

import Model.Product;

import java.io.*;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServiceImp implements Service {
    private Product inputProduct() {
        Product product = new Product();
        System.out.print("Insert Product name: ");
        String name = new Scanner(System.in).nextLine();
        product.setName(name);
        System.out.print("Insert Product price: ");
        double price = new Scanner(System.in).nextDouble();
        product.setUnitPrice(price);
        System.out.print("Insert Product quantity: ");
        int quantity = new Scanner(System.in).nextInt();
        product.setQuantity(quantity);
        String filePath = "products.CSV";
        int lastId = 0; // Variable to hold the last used ID

        // Read the last product ID from the file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String lastLine = null, line;
            while ((line = br.readLine()) != null) {
                lastLine = line; // Keep updating lastLine until the end of file
            }
            if (lastLine != null && !lastLine.isEmpty()) {
                String[] lastProduct = lastLine.split(",");
                String lastProductId = lastProduct[0];
                lastId = Integer.parseInt(lastProductId.replaceAll("\\D+", "")); // Extract numerical part of the ID
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading product records: " + e.getMessage());
        }
        product.setId(String.format("CSTAD-%05d", lastId + 1));
        return product;
    }

    @Override
    public void addProduct() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("products.CSV", true))) {
            Product product = inputProduct();
            bufferedWriter.write(product.getId() + "," + product.getName() + "," + product.getQuantity() + "," + product.getUnitPrice());
            bufferedWriter.newLine();
            System.out.println("Product added successfully!");
        } catch (Exception exception) {
            System.out.printf(exception.getMessage());
        }
    }


    private void writeToDataSource(String data, boolean append) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("dataSource.CSV", append))) {
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.newLine();
        } catch (Exception exception) {
            System.out.printf(exception.getMessage());
        }

    }

    @Override
    public void commitToDataSource() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("products.CSV"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                writeToDataSource(line, true);
            }
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("products.CSV"))) {
                bufferedWriter.write("");
            }
            System.out.println("Data are committed to the data source!");

        } catch (Exception exception) {
            System.out.printf(exception.getMessage());
        }
    }

    @Override
    public void generateReport(int numberOfProducts) {

        String filePath = "products.CSV";
        int lastId = 0; // Variable to hold the last used ID

        // Read the last product ID from the file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String lastLine = null, line;
            while ((line = br.readLine()) != null) {
                lastLine = line; // Keep updating lastLine until the end of file
            }
            if (lastLine != null && !lastLine.isEmpty()) {
                String[] lastProduct = lastLine.split(",");
                String lastProductId = lastProduct[0];
                lastId = Integer.parseInt(lastProductId.replaceAll("\\D+", "")); // Extract numerical part of the ID
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading product records: " + e.getMessage());
        }

        // Generate new products starting from the next ID
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            Random random = new Random();
            for (int i = 1; i <= numberOfProducts; ++i) {
                int newId = lastId + i; // Calculate new ID based on the last ID
                String id = String.format("CSTAD-%05d", newId); // Corrected format specifier
                String name = "Product::%d".formatted(newId); // Use newId to ensure uniqueness
                int quantity = random.nextInt(100) + 1;
                double unitPrice = random.nextDouble() * 100;

                String productRecord = String.join(",", id, name, String.valueOf(quantity), String.format("%.2f", unitPrice));
                bw.write(productRecord);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while generating product records: " + e.getMessage());
        }
    }

    @Override
    public void searchProduct(String productName) {
        String filePath = "products.CSV";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] product = line.split(",");
                if (product[1].equalsIgnoreCase(productName)) {
                    System.out.println("Product found: " + line);
                    return;
                }
            }
            System.out.println("Product not found!");
        } catch (IOException e) {
            System.out.println("An error occurred while searching for product records: " + e.getMessage());
        }
    }


    public List<Product> readFromDataSource() {
        List<Product> products = new CopyOnWriteArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("dataSource.CSV"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] productDetails = line.split(",");
                Product product = new Product(productDetails[0], productDetails[1], Integer.parseInt(productDetails[2]), Double.parseDouble(productDetails[3]));
                products.add(product);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return products;
    }
}
