package edu.miu.cs.cs544;

import edu.miu.cs.cs544.domain.Course;
import edu.miu.cs.cs544.repository.CourseRepository;
import edu.miu.cs.cs544.service.CourseService;
import edu.miu.cs.cs544.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("edu.miu.cs.cs544.repository")
@EntityScan("edu.miu.cs.cs544.domain")
public class EnrollmentsystemApplication {
	public static void main(String[] args) {

		SpringApplication.run(EnrollmentsystemApplication.class, args);

	}
}
