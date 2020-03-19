package edu.miu.cs.cs544.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Entity

public class Section {
    @Id
    @GeneratedValue
    private int id;

    @Pattern(regexp = "[A-Z]{2}[0-9]{3}(-)[0-9]{4}(-)[0-9]{2}(-)[0-9]{2}")
    private String code;
    @JsonIgnore
    @OneToMany(mappedBy = "section")
    private List<EnrollmentRecord> enrollmentRecords;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="person_id")
    private Faculty faculty;

    public Section() {

    }

    public Section(int id,String code, List<EnrollmentRecord> enrollmentRecords, Faculty faculty) {
        this.id = id;
        this.code = code;
        this.enrollmentRecords = enrollmentRecords;
        this.faculty = faculty;
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
        for (EnrollmentRecord enrollment: enrollmentRecords
             ) {
            enrollment.setSection(this);
        }
        this.enrollmentRecords = enrollmentRecords;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
