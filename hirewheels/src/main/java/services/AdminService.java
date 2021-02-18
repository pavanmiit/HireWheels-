package services;

import entities.Vehicle;

public interface AdminService {
    public Vehicle registerVehicle(Vehicle vehicle);
    public Vehicle changeAvailability(Vehicle vehicle);
}
