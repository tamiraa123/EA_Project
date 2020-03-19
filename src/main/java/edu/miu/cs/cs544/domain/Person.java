package edu.miu.cs.cs544.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=2, max=40)
    private String firstName;
    @NotNull
    @Size(min=2, max=40)
    private String lastName;
    @NotNull
    @Size(min=2, max=20)
    private String userName;
    @NotNull
    private String password;
    @Pattern(regexp="^(STU|PROF|)$", message="invalid code")
    private String role;
    private boolean enabled;

    public Person() {
    }

    public Person(String firstName, String lastName, String userName, String password, String role){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.enabled=true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
