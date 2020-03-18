package edu.miu.cs.cs544.domain;

import java.util.Date;

public class Enrollment {
    private int blockId;
    private String blockCode;
    private String blockName;
    private String blockSemester;
    private Date blockStartDate;
    private Date blockEndDate;
    private int courseId;
    private String courseCode;
    private String courseName;
    private String courseDescription;
    private int facultyId;
    private String falcultyTitle;
    private int sectionId;

    public Enrollment(int blockId, String blockCode, String blockName, String blockSemester, Date blockStartDate, Date blockEndDate, int courseId, String courseCode, String courseName, String courseDescription, int facultyId, String falcultyTitle, int sectionId) {
        this.blockId = blockId;
        this.blockCode = blockCode;
        this.blockName = blockName;
        this.blockSemester = blockSemester;
        this.blockStartDate = blockStartDate;
        this.blockEndDate = blockEndDate;
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.facultyId = facultyId;
        this.falcultyTitle = falcultyTitle;
        this.sectionId = sectionId;
    }

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public String getBlockCode() {
        return blockCode;
    }

    public void setBlockCode(String blockCode) {
        this.blockCode = blockCode;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getBlockSemester() {
        return blockSemester;
    }

    public void setBlockSemester(String blockSemester) {
        this.blockSemester = blockSemester;
    }

    public Date getBlockStartDate() {
        return blockStartDate;
    }

    public void setBlockStartDate(Date blockStartDate) {
        this.blockStartDate = blockStartDate;
    }

    public Date getBlockEndDate() {
        return blockEndDate;
    }

    public void setBlockEndDate(Date blockEndDate) {
        this.blockEndDate = blockEndDate;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFalcultyTitle() {
        return falcultyTitle;
    }

    public void setFalcultyTitle(String falcultyTitle) {
        this.falcultyTitle = falcultyTitle;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }
}
