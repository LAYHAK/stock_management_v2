package review.lesson;

public class Address {
    private String streetNo;
    private String city;
    private String country;

    public Address() {
    }

    public Address(String streetNo, String city, String country) {
        this.streetNo = streetNo;
        this.city = city;
        this.country = country;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
