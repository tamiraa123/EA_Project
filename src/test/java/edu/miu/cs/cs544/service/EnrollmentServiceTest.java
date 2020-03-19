package edu.miu.cs.cs544.service;
import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.repository.EnrollmentRecordRepository;
import edu.miu.cs.cs544.repository.OfferingRepository;
import edu.miu.cs.cs544.repository.SectionRepository;
import edu.miu.cs.cs544.repository.StudentRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@SpringBootTest
class EnrollmentRecordServiceTest {
    List<Block> blockList=  Arrays.asList(
            new Block(1, "2020-02", "February 2020", "Summer", 2,
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-02-04"),
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-03-05")),
            new Block(2, "2020-03", "November 2020", "Spring", 1,
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-04-04"),
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-05-05")));
    List<Enrollment> EnrollmentList=  Arrays.asList(
            new Enrollment(1, "2020-01", "August 2020", "1",
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-04-04"),
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-05-04"),
                    1, "CS544", "EA", "Enterprise Architecture",
                    1, "Professor", 1),
            new Enrollment(2, "2020-10", "October 2020", "2",
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-09-04"),
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-10-04"),
                    1, "CS401", "MPP", "MPP",
                    1, "Doctor", 1));
    List<EnrollmentStudent> EnrollmentStudentList=  Arrays.asList(
            new EnrollmentStudent(1, "2020-01", "August 2020", "1",
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-04-04"),
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-05-04"),
                    1, "CS544", "EA", "Enterprise Architecture",
                    1, "Professor", 1,"Tamir","Baldandorj",610571),
            new EnrollmentStudent(2, "2020-10", "October 2020", "2",
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-09-04"),
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-10-04"),
                    1, "CS401", "MPP", "MPP",
                    1, "Doctor", 1,"Sergelen","Enkhee",610711));
    Student student = new Student("Tamir","Baldandorj","Tamir","123","ROLE_STUDENT",610571,"tamir@gmail.com");

    Course course1 = new Course("CS544","EA","Enterprise Architecture");

    Course course2 = new Course("CS401","MPP","MPP");
    Offering offering = new Offering(1,"CS544-2020-01",course1,blockList.get(0));
    Faculty faculty = new Faculty("Salek","Payman","Salek","123","ROLE_FACULTY","Professor");
    Section section = new Section(1,"CS544-2020-01-01",null,faculty);


    @Mock
    EnrollmentRecordRepository enrollmentRecordRepository;
    @InjectMocks
    EnrollmentRecordService enrollmentRecordService;
    EnrollmentRecordServiceTest() throws ParseException {
    }
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void enrollmentAdmin() {
        when(enrollmentRecordRepository.EnrollmentViewAdmin()).thenReturn(EnrollmentList);
        Assertions.assertEquals(enrollmentRecordService.EnrollmentAdmin(), EnrollmentList);
    }
    @Test
    void enrollmentFaculty() {
        when(enrollmentRecordRepository.EnrollmentViewFaculty(Mockito.anyInt(),Mockito.anyInt())).thenReturn(EnrollmentStudentList);
        Assertions.assertEquals(enrollmentRecordService.EnrollmentFaculty(1,1).size(), 2);
    }
//    @Test
//    void enroll() {
//        student.setId(1);
//        EnrollmentRecord enrollmentRecord = new EnrollmentRecord(1,section,student);
//        when(enrollmentRecordRepository.save(enrollmentRecord)).thenReturn(enrollmentRecord);
//        Assertions.assertEquals(enrollmentRecordService.Enroll(enrollmentRecord),enrollmentRecord);
//    }
//    @Test
//    void editEnroll() {
//        EnrollmentRecord enrollmentRecord = new EnrollmentRecord(1,section,student);
//        when(enrollmentRecordRepository.save(enrollmentRecord)).thenReturn(enrollmentRecord);
//        Assertions.assertEquals(enrollmentRecordService.Enroll(enrollmentRecord),enrollmentRecord);
//    }
}