package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class City {
    public City(int city_id, String city_name) {
        this.city_id = city_id;
        this.city_name = city_name;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public City(Set<Vehicle> vehicles, int city_id, String city_name) {
        this.vehicles = vehicles;
        this.city_id = city_id;
        this.city_name = city_name;
    }

    @Override
    public String toString() {
        return "City{" +
                "vehicles=" + vehicles +
                ", city_id=" + city_id +
                ", city_name='" + city_name + '\'' +
                '}';
    }

    @OneToMany (mappedBy = "city", fetch = FetchType.EAGER)
    private Set<Vehicle> vehicles;

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    @Id
    @GeneratedValue
    private int city_id;

    @Column(length=20,nullable = false)
    private String city_name;

}
