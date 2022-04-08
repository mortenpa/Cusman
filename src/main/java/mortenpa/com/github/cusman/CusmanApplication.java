package mortenpa.com.github.cusman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CusmanApplication {

	public static void main(String[] args) {
		SpringApplication.run(CusmanApplication.class);
	}

}
