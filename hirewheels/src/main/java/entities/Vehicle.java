package entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue
    private int vehicleId;

    @Column(nullable = false,length = 50)
    public String vehicleModel;

    @Column(nullable = false,length = 20)
    public String vehicleNumber;

    @Column(nullable = false,length = 30)
    public String vehicleName;

    @Column(nullable = false,length = 30)
    public double amount_per_hour;

    public double getAmount_per_hour() {
        return amount_per_hour;
    }

    public void setAmount_per_hour(double amount_per_hour) {
        this.amount_per_hour = amount_per_hour;
    }

    @ManyToOne
    @JoinColumn(name="vehiclesubcatagery_id",nullable = false)
    public Vehicle_subcategory vehiclecatgry;

    @ManyToOne
    @JoinColumn(name="vehicle_id",nullable = false)
    public Fule_type fuletype;

    @ManyToOne
    @JoinColumn(name="location_id",nullable = false)
    public Location address;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name="vehicle_status")
    public String status;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Vehicle_subcategory getVehiclecatgry() {
        return vehiclecatgry;
    }

    public void setVehiclecatgry(Vehicle_subcategory vehiclecatgry) {
        this.vehiclecatgry = vehiclecatgry;
    }

    public Fule_type getFuletype() {
        return fuletype;
    }

    public void setFuletype(Fule_type fuletype) {
        this.fuletype = fuletype;
    }

    public Location getAddress() {
        return address;
    }

    public void setAddress(Location address) {
        this.address = address;
    }
}
