package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Enrollment;
import edu.miu.cs.cs544.domain.EnrollmentRecord;
import edu.miu.cs.cs544.domain.EnrollmentStudent;
import edu.miu.cs.cs544.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrollmentRecordRepository extends JpaRepository<EnrollmentRecord, Integer> {
    //Admin
    @Query("select new edu.miu.cs.cs544.domain.Enrollment(b.id,b.code,b.name,b.semester,b.startDate," +
            "b.endDate,c.id,c.code,c.name,c.description,f.id,f.title,s.id) " +
            "from Offering o join o.sections s join s.faculty f join o.block b join o.course c ")
    List<Enrollment> EnrollmentViewAdmin();

    //Student
    @Query("select new edu.miu.cs.cs544.domain.Enrollment(b.id,b.code,b.name,b.semester,b.startDate," +
            "b.endDate,c.id,c.code,c.name,c.description,f.id,f.title,s.id) " +
            "from Offering o join o.sections s join s.faculty f join o.block b join o.course c " +
            "join s.enrollmentRecords e join e.student ss where ss.id=:studentId")
    List<Enrollment>  EnrollmentViewStudent(int studentId);

    //Faculty
    @Query("select new edu.miu.cs.cs544.domain.EnrollmentStudent(b.id,b.code,b.name,b.semester,b.startDate," +
            "b.endDate,c.id,c.code,c.name,c.description,f.id,f.title,s.id, ss.firstName,ss.lastName,ss.studentId ) " +
            "from Offering o join o.sections s join s.faculty f join o.block b join o.course c " +
            "join s.enrollmentRecords e join e.student ss where ss.id=:facultyId")
    List<EnrollmentStudent>  EnrollmentViewFaculty(int facultyId);

}
