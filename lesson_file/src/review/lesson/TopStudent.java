package review.lesson;

public class TopStudent extends Student {
    private int numberOfAwards;
    private int numberOfCertificates;

    public TopStudent() {

    }


    public TopStudent(int id, String name, float[] score, Address address, int numberOfAwards, int numberOfCertificates) {
        super(id, name, score, address);
        this.numberOfAwards = numberOfAwards;
        this.numberOfCertificates = numberOfCertificates;
    }

    @Override
    public String toString() {
        return "TopStudent{%snumberOfAwards=%d, numberOfCertificates=%d}".formatted(super.toString(), numberOfAwards, numberOfCertificates);
    }

    public int getNumberOfAwards() {
        return numberOfAwards;
    }

    public void setNumberOfAwards(int numberOfAwards) {
        this.numberOfAwards = numberOfAwards;
    }

    public int getNumberOfCertificates() {
        return numberOfCertificates;
    }

    public void setNumberOfCertificates(int numberOfCertificates) {
        this.numberOfCertificates = numberOfCertificates;
    }
}
