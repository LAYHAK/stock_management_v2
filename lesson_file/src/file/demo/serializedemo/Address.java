package file.demo.serializedemo;

import java.io.Serializable;
import java.util.Scanner;

public class Address implements Serializable {
    private String streetNo;
    private String village;
    private String commune;
    private String district;
    private String province;

    public Address() {

    }

    public Address(String streetNo, String village, String commune, String district, String province) {
        this.streetNo = streetNo;
        this.village = village;
        this.commune = commune;
        this.district = district;
        this.province = province;
    }

    public Address addAddress(Scanner input) {
        System.out.println("Enter Street No:");
        streetNo = input.nextLine();
        System.out.println("Enter Village:");
        village = input.nextLine();
        System.out.println("Enter Commune:");
        commune = input.nextLine();
        System.out.println("Enter District:");
        district = input.nextLine();
        System.out.println("Enter Province:");
        province = input.nextLine();
        return this;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetNo='" + streetNo + '\'' +
                ", village='" + village + '\'' +
                ", commune='" + commune + '\'' +
                ", district='" + district + '\'' +
                ", province='" + province + '\'' +
                '}';
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
