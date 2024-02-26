package review.lesson;

public class Main {
    public static void main(String[] args) {
        TopStudent student = new TopStudent(1001, "Layhak",
                new float[]{1, 30, 40, 50},
                new Address("St.102", "Phnom Penh", "cambodia"),
                1, 100);
        System.out.println(student);
    }
}
