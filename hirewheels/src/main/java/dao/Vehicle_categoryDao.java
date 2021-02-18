package dao;

import entities.Vehicle_category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Vehicle_categoryDao extends JpaRepository<Vehicle_category,Integer> {
    public Vehicle_category findByVehicleCategoryId(int i);
}
