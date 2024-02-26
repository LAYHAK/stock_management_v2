package service;

public interface Service {
    void addProduct();

    void commitToDataSource();

    void generateReport(int numberOfProducts, int rowPerPage, int currentPage);

    void searchProduct(String productName);
}
