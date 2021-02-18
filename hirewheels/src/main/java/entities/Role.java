package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {
    public Role(int userId, String userType) {
        UserId = userId;
        this.userTypename = userType;
    }

    @Id
    @GeneratedValue
    private int UserId;
    @Column(nullable = false)
    private String userTypename;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserType() {
        return userTypename;
    }

    public void setUserType(String userType) {
        this.userTypename = userType;
    }
}
