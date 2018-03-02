package pl.pborawski.HomeServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.pborawski.HomeServer.dao.entity.User;
import pl.pborawski.HomeServer.dao.service.UserService;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = findUserbyUername(username);
        UserBuilder builder;
        if (user.isPresent()) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(new BCryptPasswordEncoder().encode(user.get().getPasswordHash()));
            builder.roles(String.valueOf(user.get().getRole()));
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        return builder.build();
    }

    private Optional<User> findUserbyUername(String username) {
        return userService.geUserByEmail(username);
    }
}
