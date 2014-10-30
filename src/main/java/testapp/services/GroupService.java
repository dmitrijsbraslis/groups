package testapp.services;

import testapp.domain.Group;
import org.springframework.stereotype.Service;
import testapp.domain.GroupCategories;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class GroupService {
    public int groupId = 1;
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

    public void addGroup(String name, String text, int category, boolean isOpen) {
        Group newGroup = new Group();
        newGroup.setName(name);
        newGroup.setCategory(category);
        newGroup.setDescription(text);
        newGroup.setIs_open(isOpen);
        newGroup.setId(groupId);
        groups.put(groupId, newGroup);
        groupId++;
    }
}
