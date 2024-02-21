package thread;

class Data {
    int msg;

    boolean valueSet = false;

    public synchronized void setMsg(int msg) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (valueSet) {
            try {
                wait();
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        System.out.println("Produce: " + msg);
        this.msg = msg;
        valueSet = true;
        notify();
    }

    public synchronized void getMsg() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (!valueSet) {
            try {
                wait();
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        System.out.println("Consume: " + msg);
        valueSet = false;
        notify();
    }
}

public class WaitDemo {
    public static void main(String[] args) {

        Data data = new Data();
        Thread producer = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; ++i) {
                    data.setMsg(i);
                }
            }
        };
        Thread consumer = new Thread() {
            @Override
            public void run() {

                for (int i = 0; i < 5; ++i) {
                    data.getMsg();
                }
            }
        };
        producer.start();
        consumer.start();
        try {
            producer.join();
            consumer.join();
            System.out.println("Operation Completed");
        } catch (Exception ex) {
            ex.fillInStackTrace();
        }
    }

}
