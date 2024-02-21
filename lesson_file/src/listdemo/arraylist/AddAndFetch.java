package listdemo.arraylist;

import java.util.ArrayList;
import java.util.List;

public class AddAndFetch {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("List:" + list);
        List<Integer> newList = new ArrayList<>();
        newList.add(10);
        newList.add(20);
        newList.add(30);
        System.out.println("New List:" + newList);
        //add newList to list at the end
        list.addAll(newList);
        System.out.println("List:" + list);
        //add at specific index
        list.addAll(0, newList);
        System.out.println("List:" + list);
        System.out.println("The element at index two is " + list.get(1));

        System.out.println("The size of the List is  " + list.size());
    }
}