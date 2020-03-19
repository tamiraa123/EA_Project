package edu.miu.cs.cs544.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Faculty extends Person{

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Section section;

    @NotNull
    @Pattern(regexp="^(Student|Professor|)$", message="invalid code")
    private String title;



    public Faculty() {

    }
    public Faculty(String firstName, String lastName, String userName, String password, String role, String title){
        super(firstName, lastName, userName, password, "ROLE_FACULTY");
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
