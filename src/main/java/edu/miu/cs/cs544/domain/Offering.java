package edu.miu.cs.cs544.domain;


import javax.persistence.*;
import java.util.List;

@Entity
public class Offering {
    @Id
    @GeneratedValue
    private int id;
    private String code;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="offering_id")
    private List<Section> sections;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;
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

    public Course getCourses() {
        return course;
    }

    public void setCourses(Course course) {
        this.course = course;
    }

    public Block getBlocks() {
        return block;
    }

    public void setBlocks(Block block) {
        this.block = block;
    }
}
