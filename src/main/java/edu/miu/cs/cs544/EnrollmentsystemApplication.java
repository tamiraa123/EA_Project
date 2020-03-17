package edu.miu.cs.cs544;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("edu.miu.cs.cs544.repository")
//@EntityScan("edu.miu.cs.cs544.domain")
public class EnrollmentsystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(EnrollmentsystemApplication.class, args);
	}

}
