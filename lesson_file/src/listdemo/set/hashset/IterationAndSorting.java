package listdemo.set.hashset;

import java.util.*;

public class IterationAndSorting {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(23);
        set.add(34);
        set.add(56);
        System.out.println("Using Iterator:");
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("Using Foreach Method:");
        set.forEach(System.out::println);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        list.forEach(System.out::print);
    }
}
