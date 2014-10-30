package testapp.controllers;

import org.springframework.web.bind.annotation.RequestParam;
import testapp.domain.GroupCategories;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMainPage(Model model) {
        model.addAttribute("allGroups", groupService.getAllGroups());
        model.addAttribute("allCat", GroupCategories.values());
        return "groups";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addGroup(
            Model model,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("category") int category,
            @RequestParam("is_open") boolean isOpen) {

        groupService.addGroup(name, description, category, isOpen);
        return getMainPage(model);
    }
}
