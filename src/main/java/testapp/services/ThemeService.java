package testapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testapp.domain.Theme;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ThemeService {
    public Map<Long, Integer> groupIdThemeId = new HashMap<Long, Integer>();
    public Map<Long, String> themes = new HashMap<Long, String>();

    @PostConstruct
    public void fillHashMap() {
        groupIdThemeId.put(1L, 1);
        groupIdThemeId.put(2L, 1);
        groupIdThemeId.put(3L, 2);
        groupIdThemeId.put(4L, 3);
        groupIdThemeId.put(5L, 4);

        themes.put(1L, "theme for group 1");
        themes.put(2L, "theme for group 1 second");
        themes.put(3L, "theme for group 2");
        themes.put(4L, "theme for group 3");
        themes.put(5L, "theme for group 4");
    }

    public List<Theme> getGroupThemes(int groupId) {
        List<Theme> groupThemes = new ArrayList<Theme>();
        for (Map.Entry<Long, Integer> entry : groupIdThemeId.entrySet()) {
            if (entry.getValue().equals(groupId)) {
                Theme oneTheme = new Theme();
                oneTheme.setId(entry.getKey());
                oneTheme.setText(themes.get(entry.getKey()));
                groupThemes.add(oneTheme);
            }
        }
        return groupThemes;
    }

    public void addTheme(int groupId, String text) {
        if (text == null) {
            throw new IllegalArgumentException("Empty text");
        }
        long newThemeId = System.currentTimeMillis();
        groupIdThemeId.put(newThemeId, groupId);
        themes.put(newThemeId, text);
    }
}
