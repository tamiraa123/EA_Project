package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Enrollment;
import edu.miu.cs.cs544.domain.Section;
import edu.miu.cs.cs544.domain.Student;
import edu.miu.cs.cs544.repository.OfferingRepository;
import edu.miu.cs.cs544.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public class EnrollmentRecordService {
    @Autowired
    OfferingRepository offeringRepository;
    @Autowired
    StudentRepository studentRepository;

    public List<Enrollment> EnrollmentAdmin()
    {
        return offeringRepository.EnrollmentViewAdmin();
    }
    public List<Enrollment>  EnrollmentStudent()
    {
        return offeringRepository.EnrollmentViewStudent();
    }
    public List<Enrollment>  EnrollmentFaculty()
    {
        return offeringRepository.EnrollmentViewFaculty();
    }
    public void Enroll(Section section, Student student){
        Optional<Student> rollStudent = studentRepository.findById(student.getId());
        if(rollStudent != null)
        {

        }
    }
}
