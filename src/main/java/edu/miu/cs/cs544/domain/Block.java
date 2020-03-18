package edu.miu.cs.cs544.domain;

import javax.persistence.*;

import javax.validation.constraints.*;
import java.util.Date;

@Entity

public class Block {
    @Id
    @GeneratedValue
    private int id;
    @NotEmpty
    @Pattern(regexp = "[0-9]{4}(-)[0-9]{2}")
    private String code;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]+\\s[0-9]{4}$")
    private String name;
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String semester;
    private int sequenceNumber;
    @Temporal(TemporalType.DATE)
    @FutureOrPresent
    private Date startDate;
    @Future
    @Temporal(TemporalType.DATE)
    private Date endDate;
    public Block() {}
    public Block(int id, @Pattern(regexp = "[0-9]{4}(-)[0-9]{2}") String code,
                 @Pattern(regexp = "^[a-zA-Z]+\\s[0-9]{4}$") String name,
                 @Pattern(regexp = "^[a-zA-Z]+$") String semester,
                 int sequenceNumber,
                 @FutureOrPresent Date startDate,
                 @Future Date endDate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.semester = semester;
        this.sequenceNumber = sequenceNumber;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Block{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", semester='" + semester + '\'' +
                ", sequenceNumber=" + sequenceNumber +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
