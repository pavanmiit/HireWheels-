package services;

import dao.VehicleDao;
import entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServiceImpl implements AdminService{


    @Autowired
    VehicleDao vehicleDao;

    @Override
    public Vehicle registerVehicle(Vehicle vehicle) {
        vehicle.setStatus("avlable");
        vehicleDao.save(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle changeAvailability(Vehicle vehicle) {
        vehicle.setStatus("booked");
        return vehicle;
            }
}
