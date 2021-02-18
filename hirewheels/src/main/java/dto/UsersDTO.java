package dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import entities.Booking;
import entities.Role;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

public class UsersDTO {

    private int customerId;
    private String firstName;
    private String lastName;
    private String username;
     private String password;
    private LocalDateTime dateOfBirth;
    private Set<Booking> bookings;
    public String email;
    private Set<Integer> phoneNumbers;
    public double wallit_money=1000.00;
    private Role userType;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Integer> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<Integer> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public double getWallit_money() {
        return wallit_money;
    }

    public void setWallit_money(double wallit_money) {
        this.wallit_money = wallit_money;
    }

    public Role getUserType() {
        return userType;
    }

    public void setUserType(Role userType) {
        this.userType = userType;
    }
}
