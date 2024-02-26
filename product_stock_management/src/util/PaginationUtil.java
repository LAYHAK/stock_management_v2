package util;

import Model.Product;
import View.ProductView;

import java.util.List;
import java.util.Scanner;

public class PaginationUtil {
    private final ProductView productView;
    public PaginationUtil(){
        productView = new ProductView();
    }
    public int first(List<Product> products, int rowPerPage, int currentPage) {
        if (currentPage == 1) {
            System.out.println("Now you stand on the first page...!");
            productView.displayProducts(products, rowPerPage, currentPage);
        } else {
            currentPage = 1;
            productView.displayProducts(products, rowPerPage, currentPage);
        }
        return currentPage;
    }
    public int previous(List<Product> products, int rowPerPage, int currentPage) {
        if (currentPage > 1) {
            currentPage--;
            productView.displayProducts(products, rowPerPage, currentPage);
        }else {
            currentPage = (int) Math.ceil((double) products.size() / rowPerPage);
            productView.displayProducts(products, rowPerPage, currentPage);
        }
        return currentPage;
    }
    public int goTo(List<Product> products, int rowPerPage, int currentPage, Scanner scanner) {
        System.out.print("Enter Page: ");
        currentPage = Integer.parseInt(scanner.next());
        scanner.nextLine();
        productView.displayProducts(products, rowPerPage, currentPage);
        return currentPage;
    }

    public int next(List<Product> products, int rowPerPage, int currentPage) {
        int totalPages = (int) Math.ceil((double) products.size() / rowPerPage);
        if (currentPage < totalPages) {
            currentPage++;
            productView.displayProducts(products, rowPerPage, currentPage);
        }else {
            currentPage = 1;
            productView.displayProducts(products, rowPerPage, currentPage);
        }
        return currentPage;
    }
    public int last(List<Product> products, int rowPerPage, int currentPage) {
        int totalPages = (int) Math.ceil((double) products.size() / rowPerPage);
        if (currentPage == totalPages) {
            System.out.println("Now you stand on the last page...!");
            productView.displayProducts(products, rowPerPage, currentPage);
        } else {
            currentPage = totalPages;
            productView.displayProducts(products, rowPerPage, currentPage);
        }
        return currentPage;
    }
}
