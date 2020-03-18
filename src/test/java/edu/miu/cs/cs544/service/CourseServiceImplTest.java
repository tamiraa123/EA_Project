package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Course;
import edu.miu.cs.cs544.repository.CourseRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@Transactional
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)

class CourseServiceImplTest {

    @Mock
    private CourseRepository courseRepository;
    private Course course;
    CourseServiceImpl courseService;

    @Before
    @Autowired
    public void setUp() throws Exception {
        courseService = new CourseServiceImpl(courseRepository);
        course = new Course("HH101","HHH","Henok Course");

    }

    @Test
    void get() {
       Optional<Course> expected = Optional.ofNullable(course);
        when(courseRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(course));
        assertEquals( courseService.get(1L),expected);
    }

    @Test
    void getCode() {
        Course expected = course;
        when(courseRepository.findByCode("HH101")).thenReturn(course);
        assertEquals(courseService.getCode("HH101"),expected);
    }

    @Test
    void getName() {
        Optional<Course> expected = Optional.ofNullable(course);
        when(courseRepository.findByName("HHH")).thenReturn(Optional.ofNullable(course));
        assertEquals(courseService.getName("HHH"),expected);
    }

    @Test
    void getAll() {
        List<Course> expectedProducts = Arrays.asList(course);
        doReturn(expectedProducts).when(courseRepository).findAll();
        // when
        Iterable<Course> actualProducts = courseService.getAll();
        // then
        assertEquals(expectedProducts,actualProducts);
    }

    @Test
    void update() {
    }
}

@Transactional
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CourseServiceImplTest2 {

    @Autowired
    @Mock
    private CourseRepository courseRepository;
    private Course course;
    CourseServiceImpl courseService;

    @Before
    @Autowired
    public void setUp() throws Exception {
        courseService = new CourseServiceImpl(courseRepository);
        course = new Course("HH101","HHH","Henok Course");

    }

    @Test
    void add() {
        Long initCount = courseRepository.count();
        course.setCode("HH101");
        course.setDescription("Henok Course");
        course.setName("HHH");
        courseService.add(course);
        Long newSize = courseRepository.count();
        assertEquals(++initCount, newSize);
    }


    @Test
    void delete() {
        courseService.add(course);
        Long initCount = courseRepository.count();
        System.out.println(courseRepository.count() + " is initial size");
        //List<Course> courses = (List<Course>)courseService.getAll();
        // int initCount = courses.size();
//        course.setCode("HH101");
//        course.setDescription("Henok Course");
//        course.setName("HHH");
        courseService.delete(course);
        Long newSize = courseRepository.count();
        assertEquals(initCount-1, newSize);
    }
}