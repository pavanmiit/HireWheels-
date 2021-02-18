package services;

import dao.VehicleDao;
import entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VehicleServiceImpl implements VehicleService{

    @Autowired
    VehicleDao vehicleDao;

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicleList=vehicleDao.findAll();
        return vehicleList;
    }

    @Override
    public Vehicle acceptVehicleDetails(Vehicle vehicle){return vehicleDao.save(vehicle);}

    @Override
    public List<Vehicle> getAvailableVehicles() {
       List<Vehicle> avlableVehicle= vehicleDao.avlablevehicle(1);
        return avlableVehicle;
    }
     @Override
    public Vehicle updateVehicletomantinance(int id){
      Vehicle vehicle=vehicleDao.findById(id).get();
          vehicle.setStatus("mantinance");
            return vehicle;

    }
}
