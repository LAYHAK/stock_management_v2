package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtromicDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(455);
        System.out.println(atomicInteger.get());
    }
}
