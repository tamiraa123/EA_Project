package edu.miu.cs.cs544.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@NoArgsConstructor
public class Section {
    @Id
    @GeneratedValue
    private int id;
    @Pattern(regexp = "[0-9]{2}")
    private String code;
    @OneToMany
    @JoinColumn(name = "student_id")
    private List<Student> students = new ArrayList<>();
}
