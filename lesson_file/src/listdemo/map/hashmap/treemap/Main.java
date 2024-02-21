package listdemo.map.hashmap.treemap;

import java.util.Comparator;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());


        treeMap.put("A", 56); //Inserting share price of Oracle in the Map.
        System.out.println(treeMap);

        treeMap.put("B", 60); //Inserting share price of Oracle again. This will update the value.
        System.out.println(treeMap);

        treeMap.putIfAbsent("C", 70); //Inserting share price of Oracle again using putIfAbsent() method. This will not update the value.
        System.out.println(treeMap);

        treeMap.comparator().reversed();
    }
}
