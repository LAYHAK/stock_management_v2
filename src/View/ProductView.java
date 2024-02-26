package View;

import Controller.ProductController;
import Model.Product;
import Pagination.StockHelp;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class ProductView {
    public static final String ANSI_BLUE = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void paginationOption() {
        Table tableMenu = new Table(6, BorderStyle.DESIGN_CURTAIN);
        tableMenu.addCell("Page Navigation:" + " ".repeat(11));
        tableMenu.addCell("     (F)irst");
        tableMenu.addCell("     (P)revious");
        tableMenu.addCell("     (G)oto ");
        tableMenu.addCell("     (N)ext");
        tableMenu.addCell("     (L)ast   ");
        System.out.println(tableMenu.render());
    }

    public void displayProducts(List<Product> products, int rowPerPage, int currentPage) {
        int size = products.size();
        int startIndex = (currentPage - 1) * rowPerPage;
        int endIndex = Math.min(startIndex + rowPerPage, size);
        Table productTable = new Table(4);
        productTable.addCell("ID");
        productTable.addCell("Name");
        productTable.addCell("Quantity");
        productTable.addCell("Unit Price");
        ListIterator<Product> productIterator = products.listIterator();
        for (int i = startIndex; i < endIndex; ++i) {
            Product product = productIterator.next();
            productTable.addCell(product.getId());
            productTable.addCell(product.getName());
            productTable.addCell(String.valueOf(product.getQuantity()));
            productTable.addCell(String.format("%.2f", product.getUnitPrice()));
        }
        System.out.println(ANSI_BLUE + productTable.render() + ANSI_RESET);
        Table table = new Table(2, BorderStyle.DESIGN_CURTAIN, ShownBorders.HEADER_ONLY);
        int totalPages = (int) Math.ceil((double) size / rowPerPage);
        table.addCell("  Page : %d of %s".formatted(currentPage, totalPages + " ".repeat(65)));
        table.addCell("Total Record : %d".formatted(size));
        System.out.println(table.render());
    }


    public static class Menu {
        static ProductController productController = new ProductController();

        public static void welcomeMsg() {
            System.out.println("✨  WELCOME TO STOCK MANAGEMENT SYSTEM  ✨");
            System.out.println("""
                     ██████╗███████╗████████╗ █████╗ ██████╗       ███████╗███╗   ███╗███████╗
                    ██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗       ██╔════╝████╗ ████║██╔════╝
                    ██║     ███████╗   ██║   ███████║██║  ██║█████╗███████╗██╔████╔██║███████╗
                    ██║     ╚════██║   ██║   ██╔══██║██║  ██║╚════╝╚════██║██║╚██╔╝██║╚════██║
                    ╚██████╗███████║   ██║   ██║  ██║██████╔╝      ███████║██║ ╚═╝ ██║███████║
                     ╚═════╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═════╝       ╚══════╝╚═╝     ╚═╝╚══════╝
                                                """
            );
        }

        public static void createTable() {
            Scanner sc = new Scanner(System.in);
            System.out.println("#  Application Menu");
            Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.SURROUND);
            table.addCell(" | Disp(l)ay");
            table.addCell(" | Rando(m) ");
            table.addCell(" | (W)rite  ");
            table.addCell(" | (E)dit   ");
            table.addCell(" | (D)elete ");
            table.addCell(" | (S)earch ");
            table.addCell(" | Set r(o)w");
            table.addCell(" | (C)ommit ");
            table.addCell(" | Bac(k) up");
            table.addCell(" | Res(t)ore");
            table.addCell(" | (H)elp   ");
            table.addCell(" | E(x)it   ");
            List<String> tableOpt;
            tableOpt = Arrays.stream(table.renderAsStringArray()).toList();
            for (String s : tableOpt) {
                System.out.println(s);
            }
            System.out.print("Command -> ");
            String options = sc.nextLine().toUpperCase();

            switch (options) {
                case "L" -> productController.displayTransaction();
                case "W" -> productController.addProduct();
                case "H" -> StockHelp.displayHelp();
                case "C" -> productController.commitToDataSource();
                case "M" -> {
                    System.out.println("Insert number of products: ");
                    String num = new Scanner(System.in).nextLine();
                    while (!num.matches("\\d+")) {
                        System.out.println("Invalid number, please try again");
                        num = new Scanner(System.in).nextLine();
                    }
                    productController.generateReport(Integer.parseInt(num));
                }
                case "E" -> {
                    System.out.println("Have a Nice Day!! \uD83D\uDC7B\uD83D\uDC7B\uD83D\uDC7B");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Option");
            }

        }


    }
}
