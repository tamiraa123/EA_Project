package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.service.EnrollmentRecordService;
import edu.miu.cs.cs544.service.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @RequestMapping(value="/faculty/{facultyId}/enrollments/{blockid}",method = RequestMethod.GET)
    public List<EnrollmentStudent>  getEnrollmentFaculty(@PathVariable int facultyId, @PathVariable int blockid)
    {
        return enrollmentRecordService.EnrollmentFaculty(facultyId,blockid);
    }

    //Student
    @RequestMapping(value="/student/enrollments/{studentId}",method = RequestMethod.GET)
    public List<Enrollment>  getEnrollmentStudent(@PathVariable int studentId)
    {
        return enrollmentRecordService.EnrollmentStudent(studentId);
    }

    @RequestMapping(value="/admin",method = RequestMethod.POST)
    public EnrollmentRecord EnrollCourse(@RequestBody EnrollmentRecord enrollmentRecord) {
            return enrollmentRecordService.Enroll(enrollmentRecord);
    }


    @RequestMapping(value="/admin/{id}",method = RequestMethod.PATCH)
    public void editEnrollCourse(@RequestBody EnrollmentRecord enrollmentRecord,@PathVariable int id) {
        enrollmentRecordService.editEnroll(enrollmentRecord,id);
    }

    @RequestMapping(value="/admin",method = RequestMethod.DELETE)
    public void deleteEnrollCourse(@RequestBody EnrollmentRecord enrollmentRecord) {

        enrollmentRecordService.deleteEnroll(enrollmentRecord);
    }
}
