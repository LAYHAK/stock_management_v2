package listdemo.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//? The Iterator can't insert or update element
public class Iterating {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        for (int i = 0; i < list.size(); i++) { //Simple for loop
            System.out.println(list.get(i));
        }
        System.out.println(list);

        for (Integer i : list) {   //Enhanced for loop
            System.out.println(i);
        }
        System.out.println(list);
        //todo Using Iterator
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        //todo Iterating using forEachRemaining() method
        System.out.println("Iterating using forEachRemaining() method");
        Iterator<Integer> newItr = list.iterator();
//todo        newItr.forEachRemaining(element -> System.out.println(element));
        newItr.forEachRemaining(System.out::println);

//todo remove element using Iterator
        while (itr.hasNext()) {
            int next = itr.next();
            if (next == 30) {
                itr.remove();
            }
        }
        System.out.println(list);
    }
}
