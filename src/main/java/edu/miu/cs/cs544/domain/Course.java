package edu.miu.cs.cs544.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Entity

public class Course {
    @Id
    @GeneratedValue
    private long id;
    @Pattern(regexp = "[A-Z]{2}[0-9]{3}")
    private String code;
    private String name;
    private String description;

    public Course() {
    }
    public Course(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(code, course.code) &&
                Objects.equals(name, course.name) &&
                Objects.equals(description, course.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, description);
    }
}
