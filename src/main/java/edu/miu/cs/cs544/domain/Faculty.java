package edu.miu.cs.cs544.domain;

import javax.persistence.*;

@Entity

public class Faculty extends Person{
    @Id
    @GeneratedValue
    private int id;
    private String title;
    @OneToOne
    @JoinColumn(name="person_id")
    private Section section;

    public Faculty() {
    }
    public Faculty(String firstName, String lastName, String userName, String password, String role, String title){
        super(firstName, lastName, userName, password, role);
        this.title = title;
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
