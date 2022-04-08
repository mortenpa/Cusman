package mortenpa.com.github.cusman;

import mortenpa.com.github.cusman.model.Client;
import mortenpa.com.github.cusman.model.Country;
import mortenpa.com.github.cusman.model.User;
import mortenpa.com.github.cusman.repository.ClientRepository;
import mortenpa.com.github.cusman.repository.CountryRepository;
import mortenpa.com.github.cusman.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CusmanApplication {


	private static final Logger log = LoggerFactory.getLogger(CusmanApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CusmanApplication.class);
	}

/*
	@Bean
	public CommandLineRunner populateCountries(CountryRepository countryRepository){
		return (args) -> {
			countryRepository.save(new Country("Estonia", "EST"));
			countryRepository.save(new Country("Finland", "FIN"));
			countryRepository.save(new Country("Sweden", "SWE"));
			countryRepository.save(new Country("Latvia", "LVA"));
			countryRepository.save(new Country("Lithuania", "LTU"));
			log.info("Countries:");
			for (Country country : countryRepository.findAll()) {
				log.info(country.toString());
			}
		};
	}

	@Bean
	public CommandLineRunner generateSomeUsers(UserRepository userRepository) {
		return (args) -> {
			userRepository.save(new User("test", "testtest"));
			userRepository.save(new User("cusman", "cusmanpw"));
			userRepository.save(new User("test2", "testtest"));
		};
	}

	@Bean
	public CommandLineRunner demo(ClientRepository clientRepository) {
		return (args) -> {
			// save a few clients
			clientRepository.save(new Client("Jack", "Bauer", "test"));
			clientRepository.save(new Client("Chloe", "O'Brian", "cusman"));
			clientRepository.save(new Client("Kim", "Bauer", "cusman"));
			clientRepository.save(new Client("David", "Palmer", "cusman"));
			clientRepository.save(new Client("Michelle", "Dessler", "cusman"));
		};
	}
*/

}
