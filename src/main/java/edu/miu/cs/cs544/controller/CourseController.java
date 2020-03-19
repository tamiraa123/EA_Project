package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Course;
import edu.miu.cs.cs544.exception.NoSuchResourceException;
import edu.miu.cs.cs544.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService=courseService;
    }
    @PostMapping
   // @Secured(value = {"ROLE_ADMIN"})
    public ResponseEntity<Object> addCourse(@RequestBody @Valid Course course) {
        courseService.add(course);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(course.getName())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/faculty")
    public Iterable<Course> getAllCourse() {
        return courseService.getAll();
    }

    @DeleteMapping("/{id}")
    //@Secured(value = {"ROLE_ADMIN"})
    public Course deleteCourse(@PathVariable int id) {
        return courseService.get(id).map(c -> {
            courseService.delete(c);
            return c;
        }).orElse(null);
    }

    @PutMapping("/{name}")
    //@Secured(value = {"ROLE_ADMIN"})
    public Course updateCourse(@PathVariable String name, @RequestBody @Valid Course newCourse) {
        Course oldCourse = courseService.getName(name).orElse(newCourse);
        oldCourse.setName(newCourse.getName());
        oldCourse.setDescription(newCourse.getDescription());
        return courseService.update(oldCourse);
    }

    @GetMapping("student/{name}")
    public Course getCourse(@PathVariable String name) {
        return courseService.getName(name).orElseThrow(() ->
                new NoSuchResourceException(name, Course.class));
    }
}