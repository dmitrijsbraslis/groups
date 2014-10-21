package testapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import testapp.services.ThemeService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @RequestMapping(value = "/group/{groupId}/themes")
    public String getThemesPage(HttpServletRequest request, Model model, @PathVariable Integer groupId) {
        String themeText = request.getParameter("themeText");
        themeService.addTheme(groupId, themeText);
        model.addAttribute("groupid", groupId);
        model.addAttribute("groupThemes", themeService.getGroupThemes(groupId));
        return "themes";
    }

    /*
    @RequestMapping(value = "/group/addTheme", method = RequestMethod.POST)
    public String addTheme(HttpServletRequest request, Model model) {
        String themeText = request.getParameter("themeText");
        Integer groupId = Integer.parseInt(request.getParameter("groupId"));
        themeService.addTheme(groupId, themeText);
        model.addAttribute("groupid", groupId);
        model.addAttribute("groupThemes", themeService.getGroupThemes(groupId));
        return "themes";
    }
    */
}
