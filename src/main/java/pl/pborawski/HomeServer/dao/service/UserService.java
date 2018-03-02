package pl.pborawski.HomeServer.dao.service;

import pl.pborawski.HomeServer.dao.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(long id);
    Optional<User> geUserByEmail(String email);
    List<User> getAllUsers();
    //User createUser(CurrentUser form);
}
