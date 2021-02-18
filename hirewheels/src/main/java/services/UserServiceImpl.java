package services;

import dao.UsersDao;
import entities.Booking;
import entities.Users;
import exceptions.UserAlreadyExists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService{


    @Autowired
    UsersDao usersDao;
    @Override
    public Users createUser(Users use) throws Exception{
           Users mail=usersDao.finfByemail(use.getEmail());
          if(mail!=null){
              throw new UserAlreadyExists("user is already exixt");
          }else
          {
              usersDao.save(use);
          }
        return mail;
    }

    @Override
    public Users getUser(String email, String pass) {
        Users mail=usersDao.finfByemail(email);
        if(mail.getPassword().equals(pass)){
            System.out.println("welcome");
        }else {
            System.out.println("Unauthorized Users");
        }
        return mail;
            }

    @Override
    public Users getUserByemail(String email) {
        return usersDao.finfByemail(email);
    }

    @Override
    public Users getUserbyname(String name) {
        return usersDao.finfByfirstName(name);
    }

    @Override
    public Users getUserbyusername(String username) {
        return usersDao.findByusername(username);
    }

    @Override
            public Users findById(String email){
             Users user= usersDao.finfByemail(email);
              return user;

            }

    @Override
    public List<Booking> allBookingByUser(String email) {
        return usersDao.allBooking(email);
    }

    @Override
    public Users updateBalenc(Users users,double newammount) {
        users.setWallit_money(newammount);
        usersDao.save(users);
        return users;
    }

}
