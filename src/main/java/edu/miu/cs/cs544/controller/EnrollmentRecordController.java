package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.service.EnrollmentRecordService;
import edu.miu.cs.cs544.service.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="enrollmentRecord")
public class EnrollmentRecordController {

    @Autowired
    EnrollmentRecordService enrollmentRecordService;

    //Admin
    @RequestMapping(value="/admin/enrollments",method = RequestMethod.GET)
    public List<Enrollment> getEnrollmentAdmin()
    {
        return enrollmentRecordService.EnrollmentAdmin();
    }

    //Faculty
    @RequestMapping(value="/faculty/{facultyId}/enrollments?block={blockid}",method = RequestMethod.GET)
    public List<EnrollmentStudent>  getEnrollmentFaculty(@PathVariable int facultyId)
    {
        return enrollmentRecordService.EnrollmentFaculty(facultyId);
    }

    //Student
    @RequestMapping(value="/getEnrollmentStudent/{studentId}",method = RequestMethod.GET)
    public List<Enrollment>  getEnrollmentStudent(@PathVariable int studentId)
    {
        return enrollmentRecordService.EnrollmentStudent(studentId);
    }

    @RequestMapping(value="/enrollCourse",method = RequestMethod.POST)
    public String EnrollCourse(@RequestBody EnrollmentRecord enrollmentRecord) {
//         if(enrollmentRecord.size()>4)
//            return "FAIL";
//         else
            return enrollmentRecordService.Enroll(enrollmentRecord);
    }


    @RequestMapping(value="/editEnrollCourse",method = RequestMethod.PATCH)
    public void editEnrollCourse(@RequestBody EnrollmentRecord enrollmentRecord) {
        enrollmentRecordService.editEnroll(enrollmentRecord);
    }

    @RequestMapping(value="/deleteEnrollCourse",method = RequestMethod.POST)
    public void deleteEnrollCourse(@RequestBody EnrollmentRecord enrollmentRecord) {
        enrollmentRecordService.deleteEnroll(enrollmentRecord);
    }
}
