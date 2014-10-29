package testapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import testapp.services.ThemeService;

@Controller
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @RequestMapping(value = "/group/{groupId}/themes", method = RequestMethod.GET)
    public String getThemesPage(Model model, @PathVariable int groupId) {
        model.addAttribute("groupId", groupId);
        model.addAttribute("groupThemes", themeService.getGroupThemes(groupId));
        return "themes";
    }

    @RequestMapping(value = "/group/{groupId}/themes", method = RequestMethod.POST)
    public String addThemesPage(
            Model model,
            @PathVariable int groupId,
            @RequestParam("themeText") String themeText) {

        themeService.addTheme(groupId, themeText);
        return getThemesPage(model, groupId);
    }
}
