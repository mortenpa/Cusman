package mortenpa.com.github.cusman.repository;

import mortenpa.com.github.cusman.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}
