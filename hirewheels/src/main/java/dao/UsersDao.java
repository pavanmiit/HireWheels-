package dao;

import entities.Booking;
import entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersDao extends JpaRepository<Users, Integer> {

    public boolean findById(String email);

    public Users finfByfirstName(String name);
    public Users finfBylasttName(String name);
    public Users finfByemail(String email);
    public Users findByphoneNumbers(int number);
    public List<Users> findAll();
    public Users findById(int id);
    public Users findByusername(String username);
    public List<Booking> allBooking(String email);
}
