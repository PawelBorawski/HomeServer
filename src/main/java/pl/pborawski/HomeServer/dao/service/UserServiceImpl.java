package pl.pborawski.HomeServer.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.pborawski.HomeServer.dao.entity.User;
import pl.pborawski.HomeServer.dao.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public Optional<User> geUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

//    @Override
//    public User createUser(CurrentUser form) {
//        User user = new User();
//        user.setEmail(form.getEmail());
//        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
//        user.setRole(form.getRole());
//        return userRepository.save(user);
//    }
}
