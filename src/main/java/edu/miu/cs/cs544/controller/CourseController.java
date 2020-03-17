package edu.miu.cs.cs544.controller;


import edu.miu.cs.cs544.domain.Course;
import edu.miu.cs.cs544.exceptions.NoSuchResourceException;
import edu.miu.cs.cs544.service.CourseService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CourseController {

    @Resource
    private CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService=courseService;
    }

    @GetMapping("/")
    public String redirectRoot() {
        return "redirect:/course";
    }

    @PostMapping("/course")
   // @Secured(value = {"ROLE_ADMIN"})
    public String addNewCourse(@RequestBody @Valid Course course) {
        courseService.add(course);

        return null;
    }

    @GetMapping("/course")
    public Model getAll(Model model) {
        System.out.println("TEST");
        model.addAttribute("courses", courseService.getAll());
        return model;
    }
    @GetMapping("course/{name}")
    public Course getCourseName(@PathVariable String name) {
        return courseService.getName(name);
    }
//   @GetMapping("course/{code}")
//    public Course getCourseCode(@PathVariable String code) {
//        return courseService.getCode(code);
//    }
//    @GetMapping("course/{id}")
    public Optional getCourse(@PathVariable Long id) {
        return courseService.get(id);
    }

    @DeleteMapping("/{name}")
    //@Secured(value = {"ROLE_ADMIN"})
    public void deleteCourse(@PathVariable String name) {
            courseService.delete(courseService.getName(name));
    }

    @PutMapping("/{name}")
   // @Secured(value = {"ROLE_ADMIN"})
    public Course updateCourse(@PathVariable String name, @RequestBody @Valid Course newCourse) {
        Course oldCourse = courseService.getName(name);
        oldCourse.setName(newCourse.getName());
        oldCourse.setCode(newCourse.getCode());
        oldCourse.setDescription(newCourse.getDescription());
        return courseService.update(oldCourse);
    }

	@ExceptionHandler(value= NoSuchResourceException.class)
	public ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.getModel().put("e", e);
		mv.setViewName("noSuchResource");
		return mv;
	}
}
