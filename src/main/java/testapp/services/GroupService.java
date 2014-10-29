package testapp.services;

import testapp.domain.Group;
import org.springframework.stereotype.Service;
import testapp.domain.GroupCategories;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class GroupService {
    public int group_id = 1;
    public Map<Integer, Group> groups = new HashMap<Integer, Group>();

    @PostConstruct
    public void fillHashMap() {
        for(int i = 1; i <= 30; i++) {
            addGroup("test", "test", 3, true);
        }
    }

    public Group getGroupNameById(int groupID) {
        Group group = new Group();
        group.setName(groups.get(groupID).getName());
        return group;
    }

    public List<Group> getAllGroups() {
        List<Group> allGroups = new ArrayList<Group>();
        for(Map.Entry<Integer, Group> entry : groups.entrySet()) {
            allGroups.add(entry.getValue());
        }
        return allGroups;
    }

    public void addGroup(String name, String text, int category, boolean is_open) {
        Group newGroup = new Group();
        newGroup.setName(name);
        newGroup.setCategory(category);
        newGroup.setDescription(text);
        newGroup.setIs_open(is_open);
        newGroup.setId(group_id);
        groups.put(group_id, newGroup);
        group_id++;
    }
}
