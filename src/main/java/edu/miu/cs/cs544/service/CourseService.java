package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Course;

import java.util.Optional;

public interface CourseService {

    //Create
    public Course add(Course course);

    //Read
    public Optional get(Long courseId);
    public Course getName(String name);
    public Course getCode(String name);
    public Iterable<Course> getAll();

    //Update
    public Course update(Course course);

    //Delete
    public  void delete(Course course);
}
