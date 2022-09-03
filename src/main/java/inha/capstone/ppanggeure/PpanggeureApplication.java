package inha.capstone.ppanggeure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //@CreatedDate 사용
public class PpanggeureApplication {

	public static void main(String[] args) {
		SpringApplication.run(PpanggeureApplication.class, args);
	}

}
