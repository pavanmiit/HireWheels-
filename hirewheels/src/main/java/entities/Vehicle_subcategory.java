package entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vehicle_subcategory {
    public Vehicle_subcategory(int subcatagery_id,String cat_name, int cost_per_hour,Vehicle_category vehicale_caagery) {
        this.vehicale_caagery = vehicale_caagery;
        this.subcatagery_id = subcatagery_id;
        this.cost_per_hour = cost_per_hour;
        this.cat_name = cat_name;
    }

    @Autowired
    private Vehicle_category vehicale_caagery;

@Id
@GeneratedValue
    private int subcatagery_id ;
@Column(name="vehicle_cc")
private int cost_per_hour;

@Column(name = "vehicle_category")
private String cat_name;
}
