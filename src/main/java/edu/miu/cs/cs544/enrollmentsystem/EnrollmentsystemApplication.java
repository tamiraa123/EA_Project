package edu.miu.cs.cs544.enrollmentsystem;

import edu.miu.cs.cs544.domain.Course;
import edu.miu.cs.cs544.repository.CourseRepository;
import edu.miu.cs.cs544.service.CourseService;
import edu.miu.cs.cs544.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnrollmentsystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(EnrollmentsystemApplication.class, args);

	}
}
