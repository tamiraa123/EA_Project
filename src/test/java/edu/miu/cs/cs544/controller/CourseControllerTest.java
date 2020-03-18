package edu.miu.cs.cs544.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.cs.cs544.domain.Course;
import edu.miu.cs.cs544.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CourseController.class)
class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;
    private ObjectMapper objectMapper;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    static final List<Course>  mockedCourses = Arrays.asList(
            new Course("CS544", "EA", "Enterprise Architecture"),
            new Course("CS422", "MPP", "Modern Programming Practices"),
            new Course("CS390", "FPP", "Fundamentals of Programming Practices")
    );
//    @Autowired
//    @Qualifier("entityManagerFactory")
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//
//        return sessionFactory;
//    }
    @Test
    void addCourse() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .post("/course")
                .content(asJsonString(mockedCourses.get(1)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.redirectedUrlPattern("**/course/MPP"));

              //  verify(service, times(1)).create(mockedCourses.get(1));
//        mvc.perform(MockMvcRequestBuilders
//                .post("/course")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(status().isCreated())
//                .andExpect(MockMvcResultMatchers.redirectedUrlPattern("**/course/EA"));
    }

    @Test
    void getAllCourse() throws Exception {
        when(courseService.getAll()).thenReturn(mockedCourses);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/course")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$[0].code",is("CS544")))
                .andExpect(jsonPath("$[1].code",is("CS422")))
                .andExpect(jsonPath("$[2].code",is("CS390")))
                .andExpect(jsonPath("$", hasSize(3)))

                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void deleteCourse() throws Exception {
        when(courseService.getName(mockedCourses.get(1).getName())).thenReturn(java.util.Optional.ofNullable(mockedCourses.get(1)));
        doNothing().when(courseService).delete(mockedCourses.get(1));

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/course/{name}", mockedCourses.get(1).getName())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
              ) .andExpect(status().isOk());

        verify(courseService, times(1)).getName(mockedCourses.get(1).getName());
        verify(courseService, times(1)).delete(mockedCourses.get(1));
        verifyNoMoreInteractions(courseService);

    }

    @Test
    void updateCourse() throws Exception {
        when(courseService.getName("EA")).thenReturn(Optional.of(mockedCourses.get(0)));
        when(courseService.update(any(Course.class))).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders
                .put("/course/EA")
                .content(asJsonString(mockedCourses.get(0)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)        )
                .andExpect(status().isOk());

        //Course returnedCourse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Course.class);

        verify(courseService, times(1)).getName(mockedCourses.get(0).getName());
        verify(courseService, times(1)).update(mockedCourses.get(0));
        //assertThat(returnedCourse).isInstanceOf(Course.class);

        verifyNoMoreInteractions(courseService);
    }

    @Test
    void getCourse() throws Exception {
        when(courseService.getName("FPP")).thenReturn(Optional.of(mockedCourses.get(2)));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/course/FPP")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code",is("CS390")))
                .andExpect(jsonPath("$.name",is("FPP")))
                .andExpect(jsonPath("$.description",is("Fundamentals of Programming Practices")))
                .andReturn();
    }
}