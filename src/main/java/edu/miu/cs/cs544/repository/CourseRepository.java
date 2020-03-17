package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, Long> {

    Optional<Course> findByName(String name);
    Course findByCode(String name);

}
