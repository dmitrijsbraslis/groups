package testapp.controllers;

import testapp.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FrontPageController {

    @Autowired
    private GroupService groupService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String getMainPage(Model model) {
        model.addAttribute("allGroups", groupService.getAllGroups());
        return "groups";
    }
}
