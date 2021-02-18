package services;

import dao.BookingDao;
import dao.UsersDao;
import entities.Booking;
import entities.Users;
import exceptions.InsufficientBalenc;
import org.springframework.beans.factory.annotation.Autowired;

public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingDao bookingDao;

    @Autowired
    UsersDao usersDao;

    @Autowired
    UserService userService;

    @Override
    public Booking addBooking(Booking booking, Users user) throws InsufficientBalenc {
        if(user.getWallit_money()>booking.getBookingAmmount()){
        bookingDao.save(booking);
        userService.updateBalenc(user,booking.getBookingAmmount());
        }else {throw new InsufficientBalenc("Insufficient balence");}
        return booking;
    }
}
