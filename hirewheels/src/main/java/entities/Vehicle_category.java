package entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vehicle_category {
    public Vehicle_category(int vehiclecatagryId, String getVehiclecatagry) {
        this.vehiclecatagryId = vehiclecatagryId;
        this.getVehiclecatagry = getVehiclecatagry;
    }

    @Id
    @GeneratedValue
    private int vehiclecatagryId;

    @Column(nullable = false,length =30)
   private String getVehiclecatagry;


}