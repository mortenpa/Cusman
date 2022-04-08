package mortenpa.com.github.cusman.repository;

import mortenpa.com.github.cusman.model.Country;
import org.springframework.data.repository.CrudRepository;


public interface CountryRepository extends CrudRepository<Country, Long> {
    Country findByAlpha3Code(String alpha3Code);
    Country findById(long id);
}
