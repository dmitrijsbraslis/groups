package testapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testapp.dao.ThemeDao;
import testapp.domain.Theme;
import testapp.session.CurrentUser;
import java.util.List;

@Service
public class ThemeService {

    @Autowired
    ThemeDao themeDao;

    @Autowired
    private CurrentUser currentUser;

    public List<Theme> getGroupThemes(int groupId) {
        return themeDao.getGroupThemes(groupId);
    }

    public void addTheme(int groupId, String text) {
        if (text == null) {
            throw new IllegalArgumentException("Empty text");
        } else {
            Theme newTheme = new Theme();
            newTheme.setText(text);
            newTheme.setGroupId(groupId);
            newTheme.setAuthor(currentUser.getId());
            themeDao.addTheme(newTheme);
        }
    }
}
