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

    @ManyToOne
    private EnrollmentRecord enrollmentRecord;

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

    public EnrollmentRecord getEnrollmentRecord() {
        return enrollmentRecord;
    }

    public void setEnrollmentRecord(EnrollmentRecord enrollmentRecord) {
        this.enrollmentRecord = enrollmentRecord;
    }
}
