package Pagination;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
public class StockHelp {
    public static void displayHelp(){
        Table helpTable = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE ,  ShownBorders.SURROUND);
        helpTable.addCell(" 1.  Press    l : Display All Records Of Products                        ");
        helpTable.addCell(" 2.  Press    w : Add New Product                                        ");
        helpTable.addCell(" 3.  Press    r : View product detail by code                            ");
        helpTable.addCell(" 4.  Press    e : Edit an existing product by code                                ");
        helpTable.addCell(" 5.  Press    d : Delete an existing product by code                     ");
        helpTable.addCell(" 6.  Press    s : Search an existing product by name                                           ");
        helpTable.addCell(" 7.  Press    c : Commit transactional data                                           ");
        helpTable.addCell(" 8.  Press    k : Backup data               ");
        helpTable.addCell(" 9.  Press    t : Restore data                                     ");
        helpTable.addCell("10.  Press    f : Navigate pagination to the last page                                  ");
        helpTable.addCell("11.  Press    p : Navigate pagination to the previous page                                      ");
        helpTable.addCell("12.  Press    n : Navigate pagination to the next page                                     ");
        helpTable.addCell("13.  Press    l : Navigate pagination to the last page                                ");
        helpTable.addCell("14.  Press    h : Help                                                   ");
        helpTable.addCell("15.  Press    b : Step back of the application                                                    ");
        helpTable.addCell("16.  Press    x : Exit                                                   ");
        System.out.println(helpTable.render());
    }
}
