package testapp.services;

import testapp.domain.Group;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class GroupService {
    public Map<Integer, String> groups = new HashMap<Integer, String>();

    @PostConstruct
    public void fillHashMap() {
        for(int i = 1; i <= 30; i++) {
            groups.put(i, "This is Group Nr. " + i);
        }
    }

    public Group getGroupNameById(Integer groupID) {
        Group group = new Group();
        group.setName(groups.get(groupID));
        return group;
    }
}
