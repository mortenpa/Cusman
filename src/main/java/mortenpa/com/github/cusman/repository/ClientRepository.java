package mortenpa.com.github.cusman.repository;

import java.util.List;

import mortenpa.com.github.cusman.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {

    List<Client> findByLastName(String lastName);

    Iterable<Client> findByClientManagerUser(String clientManagerUser);

    Client findById(long id);
}