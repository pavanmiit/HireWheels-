package dao;

import entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleDao extends JpaRepository<Vehicle, Integer> {
    public List<Vehicle> findAll();
    public List<Vehicle> avlablevehicle(int x);
}
