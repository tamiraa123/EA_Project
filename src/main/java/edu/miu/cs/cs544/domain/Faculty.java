package edu.miu.cs.cs544.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Faculty extends Person{
    @Id
    @GeneratedValue
    private int id;
    private String title;
    @OneToOne
    @JoinColumn(name="person_id")
    private Faculty faculty;
}
