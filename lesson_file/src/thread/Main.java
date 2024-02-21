package thread;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from my thread");
    }

}

class SecondThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from Second Thread");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Thread!!");
        MyThread obj = new MyThread();
        obj.start();
        Thread obj2 = new Thread(new SecondThread());
        obj2.start();

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Hello from Anonymous Thread class");
            }
        };
        thread.start();
        Thread threadWithRunnable = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Thread using anonymous with runnable");
            }
        });
        threadWithRunnable.start();
    }
}
