package edu.miu.cs.cs544.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Course {
    @Id
    @GeneratedValue
    private int id;
    @Pattern(regexp = "[A-Z]{2}[1-9]{3}")
    private String code;
    private String name;
    private String description;

}
