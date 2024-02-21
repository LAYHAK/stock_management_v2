package listdemo.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class UnderstandingComparableInterface {


    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Jane", 29));
        list.add(new Employee("Alex", 54));

        list.sort(Collections.reverseOrder());
        System.out.println("ArrayList in asc order: " + list);
        for (Employee employee : list) {
            System.out.println(employee.age);
        }
        //==============================================================
        List<Vehicle> listVehicle = new ArrayList<>();
        listVehicle.add(new Vehicle("Volkswagen", 2010));
        listVehicle.add(new Vehicle("Audi", 2009));
        listVehicle.add(new Vehicle("Ford", 2001));
        listVehicle.add(new Vehicle("BMW", 2015));

        Collections.sort(listVehicle);
        for (Vehicle vehicle : listVehicle) {
            System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
        }
    }
}

