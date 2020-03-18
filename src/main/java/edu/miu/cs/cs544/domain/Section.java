package edu.miu.cs.cs544.domain;

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
    @Pattern(regexp = "[0-9]{2}")
    private String code;

    @OneToMany(mappedBy = "section",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<EnrollmentRecord> enrollmentRecords;

    @OneToOne
    @JoinColumn(name="person_id")
    private Faculty faculty;

    public Section() {

    }

    public Section(String code, List<EnrollmentRecord> enrollmentRecords, Faculty faculty) {
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
