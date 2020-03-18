package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Course;
import edu.miu.cs.cs544.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

  // @Autowired
    private CourseRepository courseRepository;

    //Constructor injection
    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    //Create
    @Override
    public Course add(@Valid Course course) {
        return courseRepository.save(course);
    }

    //Read
    @Override
    public Optional<Course> get(Integer courseId) {
        return courseRepository.findById(courseId);
    }
    @Override
    @Transactional(readOnly = true)
    public Course getCode(String code) {
        return courseRepository.findByCode(code);
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<Course> getName(String name) {
        return courseRepository.findByName(name);
    }
    @Override
    @Transactional(readOnly = true)
    public Iterable<Course> getAll() {
        return courseRepository.findAll();
    }

    //Update
    @Override
    public Course update(Course course) {
        return courseRepository.save(course);
    }

    //Delete
    @Override
    public void delete(Course course) {
        courseRepository.delete(course);

    }
}
