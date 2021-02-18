package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fule_type {
    @Column(nullable = false)
    public String Fuletype;

    public String getFuletype() {
        return Fuletype;
    }

    @Override
    public String toString() {
        return "Fule_type{" +
                "Fuletype='" + Fuletype + '\'' +
                ", Fule_Id=" + Fule_Id +
                '}';
    }

    public void setFuletype(String fuletype) {
        Fuletype = fuletype;
    }

    public int getFule_Id() {
        return Fule_Id;
    }

    public void setFule_Id(int fule_Id) {
        Fule_Id = fule_Id;
    }

    public Fule_type(int fule_Id,String fuletype) {
        Fuletype = fuletype;
        Fule_Id = fule_Id;
    }

    @Id
    private int Fule_Id;
}
