package edu.miu.cs.cs544.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Entry {
    @Id
    private int id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date enrollmentStartDate;
    @Temporal(TemporalType.DATE)
    private Date enrollmentEndDate;
    @OneToMany(mappedBy="entry")
    private List<Student> students;
}
