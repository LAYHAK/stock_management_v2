package thread;

import java.util.stream.LongStream;

public class RaceDemo {
    private static long counter = 0;

    public static void main(String[] args) throws InterruptedException {
        //?create and define the task for thread

        Runnable task = new Runnable() {
            @Override
            public void run() {
                LongStream.rangeClosed(1, 100000000).forEachOrdered(i -> {
                    synchronized (this) {
                        ++counter;
                    }
                });
            }
        };
        Thread thread = new Thread(task);
        Thread anotherThread = new Thread(task);
        thread.start();
        anotherThread.start();
        thread.join();
        anotherThread.join();
        System.out.println("Expected Value=1000000000 ");
        System.out.println("Actual Value= " + counter);


    }
}
