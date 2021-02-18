package controllers;

import dao.VehicleDao;
import dto.VehicleDTO;
import entities.Vehicle;
import exceptions.APIException;
import exceptions.VehicleNotFound;
import jdk.internal.org.objectweb.asm.commons.Remapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jdk.internal.org.objectweb.asm.commons.Remapper;
import services.UserService;
import services.VehicleService;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping(value="/hirewheels/v1/vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping(value="/vehicle",produces= MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
    public ResponseEntity getAllVehicleDetials() throws Exception, APIException, VehicleNotFound {
        List<Vehicle> responseVehicle = vehicleService.getAllVehicles();
        VehicleDTO responseVehicleDTO = modelMapper.map(responseVehicle, (Type) Vehicle.class);
        return new ResponseEntity<>(responseVehicleDTO, HttpStatus.OK);
    }

    @GetMapping(value="/vehicle",produces= MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
    public ResponseEntity getAvlableVehicleDetials() throws Exception,APIException,VehicleNotFound {
        List<Vehicle> responseVehicle = vehicleService.getAvailableVehicles();
        VehicleDTO responseVehicleDTO = modelMapper.map(responseVehicle, (Type) Vehicle.class);
        return new ResponseEntity<>(responseVehicleDTO, HttpStatus.OK);
    }


}
