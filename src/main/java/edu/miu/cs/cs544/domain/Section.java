package edu.miu.cs.cs544.domain;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity

public class Section {
    @Id
    @GeneratedValue
    private int id;
    @Pattern(regexp = "[0-9]{2}")
    private String code;

    @OneToMany(mappedBy = "section")
    private List<EnrollmentRecord> enrollmentRecords;

    @OneToOne
    @JoinColumn(name="person_id")
    private Faculty faculty;

    public Section() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<EnrollmentRecord> getEnrollmentRecords() {
        return enrollmentRecords;
    }

    public void setEnrollmentRecords(List<EnrollmentRecord> enrollmentRecords) {
        this.enrollmentRecords = enrollmentRecords;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
