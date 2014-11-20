package testapp.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import testapp.domain.GroupCategories;
import testapp.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import testapp.services.UserService;
import testapp.session.CurrentUser;

@Controller
public class FrontPageController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private CurrentUser currentUser;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMainPage(Model model) {
        if (currentUser.getName() != null) {
            model.addAttribute("allGroups", groupService.getNotMyGroups());
            model.addAttribute("allCat", GroupCategories.values());
            model.addAttribute("user_name", currentUser.getName());
            model.addAttribute("user_id", currentUser.getId());
            model.addAttribute("myGroups", groupService.getMyGroups());
            return "groups";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/catalog/{catalogId}", method = RequestMethod.GET)
    public String getCatalogPage(Model model, @PathVariable int catalogId) {
        if (currentUser.getName() != null) {
            model.addAttribute("groups", groupService.getGroupsByCategory(catalogId));
            model.addAttribute("allCat", GroupCategories.values());
            model.addAttribute("user_name", currentUser.getName());
            model.addAttribute("user_id", currentUser.getId());
            model.addAttribute("categoryName", groupService.getCategoryNameById(catalogId));
            return "catalog";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addGroup(
            Model model,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "description", required = true) String description,
            @RequestParam(value = "category", required = true) int category,
            @RequestParam(value = "is_open", required = true) boolean isOpen) {

        groupService.addGroup(name, description, category, isOpen);
        return getMainPage(model);
    }
}
