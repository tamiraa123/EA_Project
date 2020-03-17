package edu.miu.cs.cs544.repository;


import edu.miu.cs.cs544.domain.Enrollment;
import edu.miu.cs.cs544.domain.Offering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferingRepository  extends JpaRepository<Offering, Integer> {
        //Admin
        @Query("select new edu.miu.cs.cs544.domain.Enrollment(b.id,b.code,b.name,b.semester,b.startDate," +
                "b.endDate,c.id,c.code,c.name,c.description,f.id,f.title,s.id) " +
                "from Offering o join o.sections s join s.faculty f join o.block b join o.course c " +
                "join s.enrollmentRecords e")
        List<Enrollment> EnrollmentViewAdmin();
        //Student

        @Query("select new edu.miu.cs.cs544.domain.Enrollment(b.id,b.code,b.name,b.semester,b.startDate,b.endDate,c.id,c.code,c.name,c.description,f.id,f.title,s.id) from Offering o join o.sections s join s.faculty f join o.block b join o.course c join s.enrollmentRecords e join e.student ss where ss.id=:id")
        List<Enrollment>  EnrollmentViewStudent();

        //Faculty
        @Query("select new edu.miu.cs.cs544.domain.Enrollment(b.id,b.code,b.name,b.semester,b.startDate,b.endDate,c.id,c.code,c.name,c.description,f.id,f.title,s.id) from Offering o join o.sections s join s.faculty f join o.block b join o.course c join s.enrollmentRecords e join e.student ss where ss.id=:id")
        List<Enrollment>  EnrollmentViewFaculty();

}
