package listdemo.set.treeset;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(21);
        list.add(32);
        list.add(44);
        list.add(11);
        list.add(54);

        TreeSet<Integer> set = new TreeSet<>(list);
        System.out.println("TreeSet elements in ascending order " + set);

        //* Adding Element to TreeSet
        TreeSet<Integer> newSet = new TreeSet<>();
        newSet.add(21);
        newSet.add(32);
        newSet.add(44);
        newSet.add(11);
        newSet.add(54);
        System.out.println("TreeSet elements in ascending order " + set);


        //* This TreeSet will store the elements in reverse order.
        TreeSet<Integer> reverseSet = new TreeSet<>(Comparator.reverseOrder());
        reverseSet.add(21);
        reverseSet.add(32);
        reverseSet.add(44);
        reverseSet.add(11);

        reverseSet.add(54);
        System.out.println("TreeSet elements in descending order " + reverseSet);

        System.out.println("Fetching the first element in TreeSet " + set.first());
        System.out.println("Fetching the last element in TreeSet " + set.last());
        System.out.println("Fetching element using subSet" + set.subSet(20, 100));
        System.out.println("Fetching all the elements less than 40 " + set.headSet(40));
        System.out.println("Fetching all the elements greater than 40 " + set.tailSet(40));


        //?Remove
        System.out.println("Removing 44 from TreeSet " + set.remove(new Integer(44)));
        System.out.println("Removing 100 from TreeSet " + set.remove(new Integer(100)));

        System.out.println(set.tailSet(20));

        //? for Checking
        System.out.println("Checking if TreeSet is empty: " + set.isEmpty());
        System.out.println("Checking the TreeSet size: " + set.size());
        System.out.println("Checking if TreeSet contains 44: " + set.contains(new Integer(44)));

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(4);
        Collection collection = new ArrayList<>();
        collection.add("hello");
        System.out.println(collection);


    }
}
