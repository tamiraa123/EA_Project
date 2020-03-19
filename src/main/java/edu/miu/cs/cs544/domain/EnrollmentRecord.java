package edu.miu.cs.cs544.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class EnrollmentRecord {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch=FetchType.LAZY)
    private Section section;

    @ManyToOne(fetch=FetchType.LAZY)
    private Student student;

    public EnrollmentRecord() {
    }

    public EnrollmentRecord(int id, Section section,Student student) {
        this.id = id;
        this.section = section;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {

        this.section = section;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
