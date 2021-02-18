package dto;

import entities.Fule_type;
import entities.Location;
import entities.Vehicle_subcategory;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class VehicleDTO {
    private int vehicleId;
    public String vehicleModel;
    public String vehicleNumber;
    public String vehicleName;
    public double amount_per_hour;
    public Vehicle_subcategory vehiclecatgry;
    public Fule_type fuletype;
    public Location address;

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

    public double getAmount_per_hour() {
        return amount_per_hour;
    }

    public void setAmount_per_hour(double amount_per_hour) {
        this.amount_per_hour = amount_per_hour;
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
