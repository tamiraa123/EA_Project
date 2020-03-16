package edu.miu.cs.cs544.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Student extends Person{
    @Id
    @GeneratedValue
    private int  id;
    private int studentId;
    private String email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "id", column = @Column(name = "home_id")),
            @AttributeOverride( name = "street", column = @Column(name = "home_street")),
            @AttributeOverride( name = "city", column = @Column(name = "home_city")),
            @AttributeOverride( name = "postalCode", column = @Column(name = "home_postalCode")),
            @AttributeOverride( name = "country", column = @Column(name = "home_country")),
    })
    private Address homeAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "id", column = @Column(name = "mailing_id")),
            @AttributeOverride( name = "street", column = @Column(name = "mailing_street")),
            @AttributeOverride( name = "city", column = @Column(name = "mailing_city")),
            @AttributeOverride( name = "postalCode", column = @Column(name = "mailing_postalCode")),
            @AttributeOverride( name = "country", column = @Column(name = "mailing_country")),
    })
    private Address mailingAddress;

    @ManyToOne
    private Entry entry;

    @OneToMany
    private Section section;
}
