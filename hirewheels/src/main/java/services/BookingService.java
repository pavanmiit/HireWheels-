package services;

import entities.Booking;
import entities.Users;
import exceptions.InsufficientBalenc;

import java.util.List;

public interface BookingService {
    public Booking addBooking(Booking booking, Users users) throws InsufficientBalenc;

}
