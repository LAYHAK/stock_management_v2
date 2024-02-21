package listdemo.linklisted;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1); // Adds 1 to the list.
        linkedList.add(2); // Adds 2 to the end of the list.
        linkedList.addLast(3); // Adds 3 to the end of the list.
        System.out.println(linkedList);

        linkedList.addFirst(10); // Adds 10 to the start of the list.
        System.out.println(linkedList);

        linkedList.add(2, 20); // Adds 20 to second position in the list.
        System.out.println(linkedList);

        List<Integer> list = new ArrayList<>();
        list.add(101);
        list.add(102);
        list.add(103);
        linkedList.addFirst(100);
        linkedList.add(200);
        linkedList.add(300);
        linkedList.add(400);
        linkedList.add(500);
        linkedList.add(600);
        linkedList.addAll(3, list); // Adds the collection of elements at third position in the list.
        System.out.println(linkedList);

        //Fetching Element
        System.out.println("Linked List first Element:" + linkedList.getFirst());
        System.out.println("Linked List last Element:" + linkedList.getLast());
        System.out.println("Linked List get Element from specific Index:" + linkedList.get(5));

        //Remove Element
        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.remove(2);
        linkedList.remove(new Integer(600));

        System.out.println(Arrays.toString(linkedList.toArray()));
        linkedList.removeFirstOccurrence(new Integer(2));
        linkedList.removeLastOccurrence(new Integer(4));
        System.out.println(Arrays.toString(linkedList.toArray()));
        //Sorting linkedList
        Collections.sort(linkedList);
        System.out.println(Arrays.toString(linkedList.toArray()));
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(10);
        copyOnWriteArrayList.addIfAbsent(10);
        System.out.println(Arrays.toString(copyOnWriteArrayList.toArray()));
        //Sorting linkedList
        CopyOnWriteArrayList<String> usingForEachList = new CopyOnWriteArrayList<>();
        usingForEachList.add("Apple");
        usingForEachList.add("Banana");
        usingForEachList.add("Orange");

        usingForEachList.forEach(System.out::println);
        Iterator<String> itrStr = usingForEachList.iterator();
        //Adding elements after creating iterator. ConcurrentModificationException will not be thrown.
        usingForEachList.add("Papaya");

        //Iterating the list through the iterator that was created earlier. Papaya will not be present.
        while (itrStr.hasNext()) {
            System.out.println(itrStr.next());
        }
        itrStr = usingForEachList.listIterator();
        while (itrStr.hasNext()) {
            System.out.println(itrStr.next());
        }
    }
}