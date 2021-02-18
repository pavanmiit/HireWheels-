package services;

import entities.Booking;
import entities.Users;
import exceptions.UserAlreadyExists;

import java.util.List;

public interface UserService {

    public Users createUser(Users user)throws UserAlreadyExists, Exception;
    public Users getUser(String email,String pass);
    public Users getUserByemail(String email);
    public Users getUserbyname(String name);
    public Users getUserbyusername(String username);
    public Users updateBalenc(Users users,double newammount);
    public Users findById(String email);
    public List<Booking> allBookingByUser(String email);
}
