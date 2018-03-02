package pl.pborawski.HomeServer.dao.repository;

import org.springframework.data.repository.CrudRepository;
import pl.pborawski.HomeServer.dao.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findOne(long id);
    Optional<User> findByEmail(String email);
    List<User> findAll();
}
