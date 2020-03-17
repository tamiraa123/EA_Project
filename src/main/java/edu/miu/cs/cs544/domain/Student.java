package edu.miu.cs.cs544.domain;


import javax.persistence.*;
import java.util.List;

@Entity
public class Student extends Person{
    @Id
    @GeneratedValue
    private int  id;
    private int studentId;
    private String email;


    @OneToOne
    @JoinColumn(name="address_home_id")
    private Address homeAddress;

    @OneToOne
    @JoinColumn(name="address_mail_id")
    private Address mailingAddress;
//    @Embedded
//    @AttributeOverrides(value={
//            @AttributeOverride( name = "id", column = @Column(name = "mailing_id")),
//            @AttributeOverride( name = "street", column = @Column(name = "mailing_street")),
//            @AttributeOverride( name = "city", column = @Column(name = "mailing_city")),
//            @AttributeOverride( name = "postalCode", column = @Column(name = "mailing_postalCode")),
//            @AttributeOverride( name = "country", column = @Column(name = "mailing_country")),
//    })
//    private Address mailingAddress;

    @ManyToOne
    private Entry entry;

    @OneToMany(mappedBy = "student")
    private List<EnrollmentRecord> enrollmentRecords;

    public Student() {

    }
    public Student(String firstName, String lastName, String userName, String password, String role, int studentId, String email){
        super(firstName, lastName, userName, password, role);
        this.studentId = studentId;
        this.email = email;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public List<EnrollmentRecord> getEnrollmentRecords() {
        return enrollmentRecords;
    }

    public void setEnrollmentRecords(List<EnrollmentRecord> enrollmentRecords) {
        this.enrollmentRecords = enrollmentRecords;
    }
}
