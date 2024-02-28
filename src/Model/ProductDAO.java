package Model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDAO {
    private final String folderName = "src/transaction/";
    private final String fileName = folderName + "transaction.dat";


    public void addProduct(Product product) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(product.getId() + "," + product.getName() + "," + product.getQuantity() + "," + product.getUnitPrice());
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> readAllTransaction() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] productDetails = line.split(",");
                Product product = new Product(productDetails[0], productDetails[1], Integer.parseInt(productDetails[2]), Double.parseDouble(productDetails[3]));
                products.add(product);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public Product readProductById(String id) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] productDetails = line.split(",");
            if (productDetails[0].equals(id)) {
                br.close();
                return productDetails.length == 4 ? new Product(productDetails[0], productDetails[1], Integer.parseInt(productDetails[2]), Double.parseDouble(productDetails[3])) : null;
            }
        }
        br.close();
        return null; // Product not found
    }

    public String backupFile() {
        String backupDirectory = "backup/";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());
        String backupFileName = "backupfile_" + timestamp + ".bak";
        return backupFileName + backupDirectory;
    }

    public void backupData(String sourceFilePath, String backupFilePath) {
        try {
            Path sourcePath = Path.of(sourceFilePath);
            Path backupFile = Path.of(backupFilePath);
            if (Files.exists(sourcePath)) {
                Files.createDirectories(backupFile.getParent());

                try (InputStream inStream = Files.newInputStream(sourcePath);
                     OutputStream outStream = Files.newOutputStream(backupFile)) {
                    byte[] buffer = new byte[8192]; // Adjust buffer size as needed
                    int bytesRead;
                    while ((bytesRead = inStream.read(buffer)) != -1) {
                        outStream.write(buffer, 0, bytesRead);
                    }
                }
                System.out.println("Backup created successfully.");
            } else {
                System.out.println("Source file does not exist.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

//    public void listingBackupFiles() {
//        String backUpDirectory = "backup/";
//        File backupDir = new File(backUpDirectory);
//        if (backupDir.exists() && backupDir.isDirectory()) {
//            File[] files = backupDir.listFiles();
//            if (files != null && files.length > 0) {
//                System.out.println("Back up files: ");
//                for (int i = 0; i < files.length; i++) {
//                    table.addCell("   " + (i + 1) + ". " + files[i].getName() + "   ");
//                }
//                System.out.println(table.render());
//            } else {
//                System.out.println("There is no backup files found");
//            }
//        } else {
//            System.out.println("Backup directory is not exist or is not a directory");
//        }
//    }
}

