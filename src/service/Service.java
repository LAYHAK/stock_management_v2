package service;

public interface Service {
    void addProduct();

    void commitToDataSource();

    void generateReport(int numberOfProducts);

    void searchProduct(String productName);
}
