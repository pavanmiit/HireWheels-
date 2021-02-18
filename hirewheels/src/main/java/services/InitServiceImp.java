package services;

import dao.*;
import java.util.*;
import entities.*;
import entities.City;
import entities.Fule_type;
import entities.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class InitServiceImp<DTOEntityConvet> implements InitService{

           @Autowired
        RoleDao userRoleDAO;

        @Autowired
        UsersDao userDAO;

        @Autowired
        Vehicle_categoryDao vehicleCategoryDAO;

        @Autowired
        Vehicle_subcategoryDao vehicleSubCategoryDAO;

        @Autowired
        CityDao cityDAO;

        @Autowired
        Fule_typeDao fuelTypeDAO;

        @Autowired
        LocationDao locationDAO;


        @Autowired
        DTOEntityConvet dtoEntityConverter;

        public void start() {
           addUserRole();
            addUsers();
            addVehicleCategory();
            addVehicleSubCategory();
            addCity();
            addFuelType();
            addLocation();
        }

        private void addLocation() {
            try {
                Location location = new Location(1, "Worli",
                        "Dr E Moses Rd, Worli Naka, Upper Worli", 400018, cityDAO.findById(1).get());
                locationDAO.save(location);
                location = new Location(2, "Chembur",
                        "Optic Complex", 400019, cityDAO.findById(1).get());
                locationDAO.save(location);
                location = new Location(3, "Powai",
                        "Hiranandani Tower", 400020, cityDAO.findById(1).get());
                locationDAO.save(location);
            }catch (Exception e){System.out.println(e);}
        }

        private void addFuelType() {
            try {
                List<Fule_type> fuelTypeList = Arrays.asList(new Fule_type(1, "Petrol"), new Fule_type(2, "Diesel"));
                fuelTypeDAO.saveAll(fuelTypeList);
            }catch (Exception e){System.out.println(e);}
        }

        private void addCity() {
            try {
                cityDAO.save(new City(1, "Mumbai"));
            }catch (Exception e){System.out.println(e);}
        }

        private void addVehicleCategory() {
            try {
                List<Vehicle_category> vehicleCategoryList = Arrays.asList(new Vehicle_category(10, "CAR"),
                        new Vehicle_category(11, "BIKE"));
                vehicleCategoryDAO.saveAll(vehicleCategoryList);
            }catch (Exception e){System.out.println(e);}
        }

        private void addVehicleSubCategory() {
            try {
                List<Vehicle_subcategory> vehicleSubCategories = new ArrayList<>();

                vehicleSubCategories.add(new Vehicle_subcategory(1, "SUV",
                        300, vehicleCategoryDAO.findByVehicleCategoryId(10)));

                vehicleSubCategories.add(new Vehicle_subcategory(2, "SEDAN",
                        350, vehicleCategoryDAO.findByVehicleCategoryId(10)));

                vehicleSubCategories.add(new Vehicle_subcategory(3, "HATCHBACK",
                        250, vehicleCategoryDAO.findByVehicleCategoryId(10)));

                vehicleSubCategories.add(new Vehicle_subcategory(4, "CRUISER",
                        200, vehicleCategoryDAO.findByVehicleCategoryId(11)));

                vehicleSubCategories.add(new Vehicle_subcategory(5, "DIRT BIKE",
                        200, vehicleCategoryDAO.findByVehicleCategoryId(11)));

                vehicleSubCategories.add(new Vehicle_subcategory(6, "SPORTS BIKE",
                        150, vehicleCategoryDAO.findByVehicleCategoryId(11)));

                vehicleSubCategoryDAO.saveAll(vehicleSubCategories);
            }catch (Exception e){System.out.println(e);}
        }

       private void addUserRole() {
try {
    List<Role> userRoleList = Arrays.asList(new Role(1, "Admin"),
            new Role(2, "User"));
    userRoleDAO.saveAll(userRoleList);
}catch (Exception e){System.out.println(e);}
        }


        private void addUsers(){
            try {
                Users adminUser = new Users("Upgrad", "Admin", "admin@123", "upgrad@gmail.com",
                        "9999999999", 10000, userRoleDAO.findByRoleId(1));
                userDAO.save(adminUser);
            }catch (Exception e){System.out.println(e);}
        }

    }


