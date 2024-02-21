package listdemo.arraylist.exercise;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Alex", 23, "USA"));
        list.add(new Employee("Dave", 34, "India"));
        list.add(new Employee("Carl", 21, "USA"));
        list.add(new Employee("Joe", 56, "Russia"));
        list.add(new Employee("Amit", 64, "China"));
        list.add(new Employee("Ryan", 19, "Brazil"));
        for (Employee emp : list) {
            if (emp.age > 50) {
                System.out.println(emp.name);
            }
        }
        System.out.println("Solution using streams");
        list.stream().filter(emp -> emp.age > 50).map(emp -> emp.name).forEach(System.out::println);
        ListIterator<Employee> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().country.equals("USA")) {
                listIterator.remove();
            }
        }
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.country.compareTo(o2.country);
            }
        });
        for (Employee emp : list) {
            System.out.println("Employee Name:" + emp.name + "Live in " + emp.country);
        }
    }
}
