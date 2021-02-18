package com.upgrad.hirewheels;

import dao.UsersDao;
import dao.VehicleDao;
import entities.Users;
import entities.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import services.UserService;
import services.VehicleService;

import java.util.Optional;

@SpringBootTest
public class VehicleServiceTest {
    @Mock
    private VehicleDao vehicleDao;

    @InjectMocks
    private VehicleService vehicleService;

    @Test
    public void testgetAllVehicles() {


    }


}
