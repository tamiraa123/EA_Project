package edu.miu.cs.cs544;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication

public class EnrollmentsystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(EnrollmentsystemApplication.class, args);


	}
}