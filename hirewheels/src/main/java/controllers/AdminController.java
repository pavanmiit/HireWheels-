package controllers;

import dto.VehicleDTO;
import entities.Vehicle;
import exceptions.APIException;
import exceptions.VehicleNotFound;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import jdk.internal.org.objectweb.asm.commons.Remapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.UserService;
import services.VehicleService;

@RestController
@RequestMapping(value="/hirewheels/v1/vehicles")
public class AdminController {

@Autowired
    VehicleService vehicleService;

@Autowired
    UserService userService;

@Autowired
ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @PostMapping(value="/vehicles",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newVehicle(@RequestBody VehicleDTO vehicleDTO, @RequestHeader(value = "ACCESS-TOKEN") String token) throws APIException,Exception {
        logger.warn("i am done looging");

        if(token == null)
            throw new Exception("Please add proper authentication");
        if(!userService.findById(token).getUserType().getUserType().equalsIgnoreCase("Admin"))
            throw new Exception("This feature is only available to admin");
        Vehicle newVehicle = modelMapper.map(vehicleDTO, Vehicle.class);
        Vehicle savedVehicle = vehicleService.acceptVehicleDetails(newVehicle);
        VehicleDTO savedVehicleDTO = modelMapper.map(savedVehicle, VehicleDTO.class);
        return new ResponseEntity<>(savedVehicleDTO, HttpStatus.CREATED);
    }
    @PutMapping(value="/vehicles/{vehicleid}",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateVehicle(@PathVariable(name = "vehicleid") int vehicleid,@RequestBody VehicleDTO vehicleDTO, @RequestHeader(value = "ACCESS-TOKEN") String token) throws APIException,Exception, VehicleNotFound {
       logger.error("there is a error loging");
        if(vehicleid == 0)
            throw new Exception("Please add proper authentication");
        if(!userService.findById(token).getUserType().getUserType().equalsIgnoreCase("Admin"))
            throw new Exception("This feature is only available to admin");
        Vehicle newVehicle = modelMapper.map(vehicleDTO, Vehicle.class);
        Vehicle updatedvehicle=vehicleService.updateVehicletomantinance(vehicleid);
        VehicleDTO savedVehicleDTO = modelMapper.map(updatedvehicle, VehicleDTO.class);
        return new ResponseEntity<>(savedVehicleDTO, HttpStatus.CREATED);
    }
}
