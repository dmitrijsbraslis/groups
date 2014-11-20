package testapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import testapp.services.UserService;
import testapp.session.CurrentUser;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private CurrentUser currentUser;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser (
            @RequestParam("login") String login,
            @RequestParam("password") String password) {

        if(userService.getUserByLogin(login) != null && userService.getUserByLogin(login).getPassword().equals(password)) {
            currentUser.setId(userService.getUserByLogin(login).getId());
            currentUser.setName(userService.getUserByLogin(login).getName());
        }

        return "redirect:";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String removeSession(HttpSession session) {
        if(currentUser.getName() != null) {
            session.invalidate();
        }

        return "redirect:";
    }
}
