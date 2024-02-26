import Controller.ProductController;
import View.ProductView;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ProductController productController = new ProductController();
        ProductView.Menu.welcomeMsg();
        do {
            ProductView.Menu.createTable();
        }while (true);


//        productController.gerneateReport(1000000);
//        productController.addProduct();
//        while (true) {
//            System.out.print("Insert opt: ");
//            int opt = new Scanner(System.in).nextInt();
//            switch (opt) {
//                case 1 -> {
//                    productController.addProduct();
//                }
//                case 2 -> {
//                    productController.displayTransaction();
//                }
//                case 3 -> {
//                    System.out.println("Insert number of products: ");
//                    int numberOfProducts = new Scanner(System.in).nextInt();
//                    productController.generateReport(numberOfProducts);
//                }
//                case 4 -> {
//                    System.out.println("Insert product name: ");
//                    String productName = new Scanner(System.in).nextLine();
//                    productController.searchProduct(productName);
//                }
//                case 5 -> {
//                    productController.generateReport(100);
////                productController.readFromDataSource();
//                }
//                case 8 -> {
//                    productController.commitToDataSource();
//                }
//                case 9 -> {
//                    System.exit(0);
//                }
//
//                default -> {
//                    System.out.print("No Option");
//                }
//            }
//        }
//        productController.displayProducts(10);
//         Create a Table instance for product and make it colorful
    }
}