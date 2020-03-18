package edu.miu.cs.cs544.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Faculty extends Person{

    @NotNull
    @Pattern(regexp="^(Student|Professor|)$", message="invalid code")
    private String title;
    @OneToOne
    @JoinColumn(name="faculty_id")
    private Section section;

    public Faculty(){
    }

    public Faculty(String title){
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
