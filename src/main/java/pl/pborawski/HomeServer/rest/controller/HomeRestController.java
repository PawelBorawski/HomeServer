package pl.pborawski.HomeServer.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pborawski.HomeServer.dao.entity.User;
import pl.pborawski.HomeServer.dao.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/home/rest")
public class HomeRestController {

    private final UserService userService;

    @Autowired
    public HomeRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}
