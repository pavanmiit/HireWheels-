package entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class Location {
    @Id
    @GeneratedValue
    private int locationId;

    public Location(int locationId, String location_name, String address, int pincode, City city) {
        this.locationId = locationId;
        this.location_name = location_name;
        this.address = address;
        this.pincode = pincode;
        this.city = city;
    }

    public String location_name;

    @Column(nullable = false)
    private String address;
@Column(nullable=false)
    private int pincode;

@Autowired
@ManyToOne
@JoinColumn(name="city_id",nullable = false)
    private City city;
}
