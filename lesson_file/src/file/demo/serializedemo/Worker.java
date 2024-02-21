package file.demo.serializedemo;

public class Worker extends Person {
    int workerID;
    float wage;
    float hours;

    Worker() {

    }

    Worker(String name, String gender, int age, Address address, int workerID, float wage, float hours) {

        super(name, gender, age, address);
        this.workerID = workerID;
        this.wage = wage;
        this.hours = hours;

    }

    public void readData() {
        super.readData();
        System.out.println("Worker id=" + workerID);
        System.out.println("Wage is=" + wage);
        System.out.println("hours is=" + hours);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "workerID=" + workerID +
                ", wage=" + wage +
                ", hours=" + hours +
                ", address=" + address +
                '}';
    }
}
