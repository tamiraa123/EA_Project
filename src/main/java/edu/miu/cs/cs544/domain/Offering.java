package edu.miu.cs.cs544.domain;


import javax.persistence.*;
import java.util.List;

@Entity
public class Offering {
    @Id
    @GeneratedValue
    private int id;
    private String code;

    @OneToMany
    @JoinColumn(name="section_id")
    private List<Section> sections;
    @OneToMany
    @JoinColumn(name="course_id")
    private List<Course> courses;
    @ManyToOne
    @JoinColumn(name="block_id")
    private Block block;

    public Offering() {
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

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}
