package review.lesson;

import java.util.Arrays;


public class Student {
    final static int NUMBER = 5;
    private int id;
    private String name;
    private float[] score;

    private Address address = new Address();

    public Student() {
    }

    public Student(int id, String name, float[] score, Address address) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.address = address;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float[] getScore() {
        return score;
    }

    public void setScore(float[] score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{id=%d, name='%s', score=%s}".formatted(id, name, Arrays.toString(score));
    }
}
