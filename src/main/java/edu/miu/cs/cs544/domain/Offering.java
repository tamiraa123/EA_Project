package edu.miu.cs.cs544.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Offering {

    @Id
    @GeneratedValue
    private int id;
    private String code;

    @OneToOne
    private  Section section;

    @OneToOne
    private  Course course;

    @OneToOne
    private  Block block;
}
