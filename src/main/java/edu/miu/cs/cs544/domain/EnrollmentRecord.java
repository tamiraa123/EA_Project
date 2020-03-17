package edu.miu.cs.cs544.domain;


import javax.persistence.*;
import java.util.List;

@Entity
public class EnrollmentRecord {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany
    private List<Section> sections;

    @OneToMany
    private List<Student> students;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


}
