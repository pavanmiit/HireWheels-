package entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Users {
    public Users(int customerId, String firstName, String lastName, String username, String password, String email) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Users(int customerId, String firstName, String lastName) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Users(String firstName, String username, String password, String email, Set<Integer> phoneNumbers, double wallit_money, Role userType) {
       // this.customerId = customerId;
        this.firstName = firstName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.wallit_money = wallit_money;
        this.userType = userType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "first_name", length = 20, nullable = false)
    private String firstName;

    @Column(length = 20)
    private String lastName;

    @Column(length = 20, nullable = false, unique = true)
    private String username;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDateTime dateOfBirth;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JsonBackReference
    private Set<Booking> bookings;

    public String email;

    @ElementCollection (fetch = FetchType.EAGER)
    @CollectionTable(name = "customer_contact_number", joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "mobile_number", nullable = false)
    private Set<Integer> phoneNumbers;

    public double wallit_money=1000.00;

    public Users(String upgrad, String admin, String password, String email, String s, int wallit_money, Role byRoleId) {
    }

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

    @Override
    public String toString() {
        return "Users{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", bookings=" + bookings +
                ", email='" + email + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", wallit_money=" + wallit_money +
                ", userType=" + userType +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "user_type_id", nullable = false)
    private Role userType;
}
