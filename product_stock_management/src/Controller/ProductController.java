package Controller;

import Model.ProductDAO;
import Model.ProductGenerator;
import View.ProductView;
import service.Service;
import service.ServiceImp;
import util.PaginationUtil;

import java.io.IOException;
import java.util.Scanner;

public class ProductController {
    private int rowPerPage = 10;
    private int currentPage = 1;
    private final ProductDAO productDao = new ProductDAO();
    private final ProductGenerator productGenerator = new ProductGenerator();
    private final ProductView productView = new ProductView();
    private final Service service = new ServiceImp();
    private final PaginationUtil paginationUtil = new PaginationUtil();
    private final Scanner scanner = new Scanner(System.in);

    public void addProduct() {
        service.addProduct();
    }

    public void commitToDataSource() {
        service.commitToDataSource();
    }

    public void displayTransaction() {
        productView.displayProducts(productDao.readAllTransaction(), rowPerPage, currentPage);
        displayData();
    }

    public void displayData(){
        do {
            productView.paginationOption();
            System.out.print("-> B)ack or Navigate page: ");
            String option = String.valueOf(scanner.next());
            switch (option.toUpperCase()){
                case "F" -> {
                    currentPage = paginationUtil.first(productDao.readAllTransaction(), rowPerPage, currentPage);
                }
                case "P" -> {
                    currentPage = paginationUtil.previous(productDao.readAllTransaction(), rowPerPage, currentPage);
                }
                case "G" -> {
                    currentPage = paginationUtil.goTo(productDao.readAllTransaction(), rowPerPage, currentPage, scanner);
                }
                case "N" -> {
                    currentPage = paginationUtil.next(productDao.readAllTransaction(), rowPerPage, currentPage);
                }
                case "L" -> {
                    currentPage = paginationUtil.last(productDao.readAllTransaction(), rowPerPage, currentPage);
                }
                case "B" -> {
                    return;
                }
                default -> {
                    System.out.println("Please choose option above!");
                }
            }
        }while (true);
    }


    public void generateReport(int numberOfProducts) {
        service.generateReport(numberOfProducts);
    }

    public void searchProduct(String productName) {
        service.searchProduct(productName);
    }

}
