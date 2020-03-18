package edu.miu.cs.cs544;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.access.annotation.Secured;

@SpringBootApplication
@EnableJpaRepositories("edu.miu.cs.cs544.repository")
@EntityScan("edu.miu.cs.cs544.domain")
public class EnrollmentsystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(EnrollmentsystemApplication.class, args);
	}
	//@Secured({ "ROLE_VIEWER", "ROLE_EDITOR" })
}
