package edu.miu.cs.cs544.domain;

import javax.persistence.*;

@Entity
public class Faculty extends Person{

    private String title;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Section section;

    public Faculty() {
    }
    public Faculty(String firstName, String lastName, String userName, String password, String role, String title){
        super(firstName, lastName, userName, password, role);
        this.title = title;
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
