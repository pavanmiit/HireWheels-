package services;

import entities.Vehicle;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface VehicleService {
    public List<Vehicle> getAllVehicles();
    public List<Vehicle> getAvailableVehicles();
    public Vehicle acceptVehicleDetails(Vehicle vehicle);
    public Vehicle updateVehicletomantinance(int id);
}
