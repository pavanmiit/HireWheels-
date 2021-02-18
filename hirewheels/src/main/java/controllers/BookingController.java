package controllers;

import dto.BookingDTO;
import dto.VehicleDTO;
import entities.Booking;
import entities.Vehicle;
import exceptions.APIException;
import exceptions.BookingNotFound;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.UserService;
import services.VehicleService;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping(value="/hirewheels/v1/bookings")
public class BookingController {
@Autowired
    UserService userService;

@Autowired
    VehicleService vehicleService;

@Autowired
ModelMapper modelMapper;



    @GetMapping(value="/bookings",produces= MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
    public ResponseEntity getBookingDetialsbyuser(String email) throws Exception, BookingNotFound, APIException {
        List<Booking> responseVehicle = userService.allBookingByUser(email);
        BookingDTO responseVehicleDTO = modelMapper.map(responseVehicle, (Type) Booking.class);
        return new ResponseEntity<>(responseVehicleDTO, HttpStatus.OK);
    }

}
