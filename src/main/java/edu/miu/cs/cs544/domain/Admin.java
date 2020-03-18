package edu.miu.cs.cs544.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin extends Person{
    @Id
    @GeneratedValue
    private int id;

    public Admin() {
    }
    public Admin(String firstName, String lastName, String userName, String password, String role){
        super(firstName, lastName, userName, password, "ADMIN_ROLE");
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
