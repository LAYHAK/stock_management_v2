package listdemo.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(12);
        list.add(9);
        list.add(76);
        list.add(29);
        list.add(75);
        //SORT ASC
        Collections.sort(list);
        System.out.println("ArrayList in asc order using sort(): " + list);
//        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        List<Integer> sortedList = list.stream().sorted().toList();
        System.out.println("ArrayList in asc order using stream: " + sortedList);
        //todo Sort DESC
//        Collections.sort(list, Collections.reverseOrder());
        list.sort(Collections.reverseOrder());
        System.out.println("ArrayList in asc order using sort(): " + list);
        sortedList = list.stream()
                .sorted(Comparator.reverseOrder()).toList();

        System.out.println("ArrayList in asc order using stream: " + sortedList);
    }
}
