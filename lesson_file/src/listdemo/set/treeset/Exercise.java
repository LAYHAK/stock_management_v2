package listdemo.set.treeset;

import java.util.TreeSet;

public class Exercise {
    public static void main(String[] args) {
        TreeSet set = new TreeSet<>();
        int[] numbers = {1, 4, 5, 2, 34, 66, 5, 4, 33, 45, 6, 8, 56, 76, 78, 98, 34, 37, 12, 12, 23, 43, 54, 56};
        for (int n : numbers) {
            set.add(n);
        }
        System.out.println(set);
        System.out.println(set.tailSet(50));
        System.out.println(set.first());
        System.out.println(set.last());
    }
}
