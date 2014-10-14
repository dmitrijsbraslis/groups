package testapp.controllers;

import testapp.domain.Group;
import testapp.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/group/{groupId}")
    public String getMainPage(Model model, @PathVariable Integer groupId) {
        groupService.fillHashMap();
        Group group = groupService.getGroupNameById(groupId);
        model.addAttribute("groupid", groupId);
        model.addAttribute("groupName", group.getName());
        return "main";
    }

    @RequestMapping(value = "/group/{groupId}/themes")
    public String getThemesPage(Model model, @PathVariable Integer groupId) {
        model.addAttribute("groupid", groupId);
        return "themes";
    }

    @RequestMapping(value = "/group/{groupId}/photos")
    public String getPhotosPage(Model model, @PathVariable Integer groupId) {
        model.addAttribute("groupid", groupId);
        return "photos";
    }

    @RequestMapping(value = "/group/{groupId}/users")
    public String getUsersPage(Model model, @PathVariable Integer groupId) {
        model.addAttribute("groupid", groupId);
        return "users";
    }

    @RequestMapping(value = "/group/{groupId}/links")
    public String getLinksPage(Model model, @PathVariable Integer groupId) {
        model.addAttribute("groupid", groupId);
        return "links";
    }
}
