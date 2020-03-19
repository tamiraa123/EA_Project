package edu.miu.cs.cs544.domain;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity

public class Entry {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date enrollmentStartDate;
    @Temporal(TemporalType.DATE)
    private Date enrollmentEndDate;

    @JsonIgnore
    @OneToMany(mappedBy="entry")
    private List<Student> students;

    public Entry() {
    }

    public Entry(int id, String name, Date startDate, Date enrollmentStartDate, Date enrollmentEndDate){
        this.name = name;
        this.startDate = startDate;
        this.enrollmentStartDate = enrollmentStartDate;
        this.enrollmentEndDate = enrollmentEndDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEnrollmentStartDate() {
        return enrollmentStartDate;
    }

    public void setEnrollmentStartDate(Date enrollmentStartDate) {
        this.enrollmentStartDate = enrollmentStartDate;
    }

    public Date getEnrollmentEndDate() {
        return enrollmentEndDate;
    }

    public void setEnrollmentEndDate(Date enrollmentEndDate) {
        this.enrollmentEndDate = enrollmentEndDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
