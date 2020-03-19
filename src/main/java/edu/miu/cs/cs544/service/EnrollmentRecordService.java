package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.repository.EnrollmentRecordRepository;
import edu.miu.cs.cs544.repository.OfferingRepository;
import edu.miu.cs.cs544.repository.SectionRepository;
import edu.miu.cs.cs544.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EnrollmentRecordService {

    @Autowired
    EnrollmentRecordRepository enrollmentRecordRepository;
    @Autowired
    OfferingRepository offeringRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SectionRepository sectionRepository;

    public List<Enrollment> EnrollmentAdmin()
    {
        return enrollmentRecordRepository.EnrollmentViewAdmin();
    }

    public List<Enrollment>  EnrollmentStudent(int studentId)
    {
        return enrollmentRecordRepository.EnrollmentViewStudent(studentId);
    }

    public List<EnrollmentStudent>  EnrollmentFaculty(int facultyId,int blockId)
    {
        return enrollmentRecordRepository.EnrollmentViewFaculty(facultyId, blockId);
    }

    public EnrollmentRecord Enroll(EnrollmentRecord enrollmentRecord) {
        boolean section = sectionRepository.existsById(enrollmentRecord.getSection().getId());
        boolean student = studentRepository.existsById(enrollmentRecord.getStudent().getId());
        if(section==true && student==true)
          return enrollmentRecordRepository.save(enrollmentRecord);
        return null;
    }
    public void editEnroll(EnrollmentRecord enrollmentRecord,int id) {
        boolean section = sectionRepository.existsById(enrollmentRecord.getSection().getId());
        boolean student = studentRepository.existsById(enrollmentRecord.getStudent().getId());
        boolean enrollment = enrollmentRecordRepository.existsById(id);
        if(section==true && student==true && enrollment==true){
                enrollmentRecord.setId(id);
                enrollmentRecordRepository.save(enrollmentRecord);
        }
    }
    public void deleteEnroll(EnrollmentRecord enrollmentRecord) {
        Optional<EnrollmentRecord> enrollment = enrollmentRecordRepository.findById(enrollmentRecord.getId());
        if(enrollment.isPresent())
            enrollmentRecordRepository.delete(enrollmentRecord);
    }
}
