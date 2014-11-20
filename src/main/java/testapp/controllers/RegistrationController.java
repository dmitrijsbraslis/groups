package testapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import testapp.services.UserService;
import testapp.session.CurrentUser;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private CurrentUser currentUser;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage() {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addUser (
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("login") String login,
            @RequestParam("password") String password) {

        if(userService.getUserByLogin(login) == null) {
            userService.addUser(name, surname, login, password);
            currentUser.setName(name);
            currentUser.setId(userService.getUserByLogin(login).getId());
            return "redirect:";
        } else {
            return "registration";
        }
    }
}
