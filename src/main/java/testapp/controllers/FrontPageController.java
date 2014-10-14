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
        String groupsList = "<div style=\"margin-top: 20px;\">";
        groupService.fillHashMap();
        for(int i=1; i <= groupService.groups.size(); i++) {
            groupsList += "<a href=\"group/" + i + "/\"><div style=\"width: 128px; height: 128px; border: 1px solid; display: inline-block; line-height: 3; text-align: center; font-size: 40px; font-family: Arial,Helvetica,sans-serif; color: gray;";
            if(i % 4 != 0) {
                groupsList += " margin-right: 55px;";
            }
            groupsList += "\">" + i + "</div></a>";
            if(i % 4 == 0) {
                groupsList += "</div><div style=\"margin-top: 20px;\">";
            }
            //groupsList += "<a href=\"group/" + i + "\">" + groupService.groups.get(i) + "</a><br>";
        }
        groupsList += "</div>";
        model.addAttribute("groupsList", groupsList);
        return "groups";
    }
}
