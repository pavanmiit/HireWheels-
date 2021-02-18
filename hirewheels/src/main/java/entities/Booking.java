package entities;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    int bookingId;

    @Column(nullable = false)
    private LocalDateTime bookingDate;

    @Column(nullable = false)
    private LocalDateTime dropoffDate;

    @Column(nullable = false)
    private LocalDateTime pickupDate;

    @ManyToOne
    @JoinColumn(name="location_id",nullable = false)
    private Location location;

    @Column(nullable = false,length = 30)
    public double bookingAmmount;

    public double getBookingAmmount() {
        return bookingAmmount;
    }

    public void setBookingAmmount(double bookingAmmount) {
        this.bookingAmmount = bookingAmmount;
    }

    @ManyToOne
    @JoinColumn(name="vehicle_id",nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name="user_id",nullable=false)
    private Users user;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }



    public Users getUser() {
        return user;
    }

    public LocalDateTime getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(LocalDateTime dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public LocalDateTime getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDateTime pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", bookingDate=" + bookingDate +
                ", dropoffDate=" + dropoffDate +
                ", pickupDate=" + pickupDate +
                ", location=" + location +
                ", vehicle=" + vehicle +
                ", user=" + user +
                '}';
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
