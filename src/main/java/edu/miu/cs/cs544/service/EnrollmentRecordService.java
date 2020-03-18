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


    public String Enroll(EnrollmentRecord enrollmentRecord) {
//        for (EnrollmentRecord enrollment : enrollmentRecord) {
                try {
                    enrollmentRecordRepository.save(enrollmentRecord);
                } catch (Exception ex) {
                    return "FAIL";
                }
//            } else {
//                return "FAIL";
//            }
//        }
        return "SUCCESS";
    }
    public void editEnroll(EnrollmentRecord enrollmentRecord,int id) {
                enrollmentRecord.setId(id);
                enrollmentRecordRepository.save(enrollmentRecord);
    }
    public void deleteEnroll(EnrollmentRecord enrollmentRecord) {
            enrollmentRecordRepository.delete(enrollmentRecord);
    }
}
