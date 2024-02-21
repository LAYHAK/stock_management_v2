package listdemo.arraylist;

public class Vehicle implements Comparable<Vehicle> {

    String brand;
    Integer makeYear;

    public Vehicle(String brand, Integer makeYear) {
        super();
        this.brand = brand;
        this.makeYear = makeYear;
    }

//    @Override
//    public int compareTo(Vehicle o) {
//        return this.makeYear - o.makeYear;
//        // We can also use the compareTo() method of the Integer class.
//        //return this.makeYear.compareTo(o.makeYear);
//    }

    @Override
    public int compareTo(Vehicle o) {
        //Using the compareTo() method of String class.
        return this.brand.compareTo(o.brand);
    }
}