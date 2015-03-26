package testapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import testapp.dao.GroupDao;
import testapp.domain.Group;
import org.springframework.stereotype.Service;
import testapp.domain.GroupCategories;
import testapp.session.CurrentUser;
import java.io.*;
import java.util.*;

@Service
public class GroupService implements Serializable {

    @Autowired
    private CurrentUser currentUser;

    @Autowired
    GroupDao groupDao;

    public Group getGroupNameById(int groupID) {
        return groupDao.getGroupNameById(groupID);
    }

    public List<Group> getGroupsByCategory(int catalogId) {
        return groupDao.getGroupsByCategory(catalogId);
    }

    public List<Group> getMyGroups() {
        return groupDao.getUserGroups(currentUser.getId());
    }

    public List<Group> getNotMyGroups() {
        return groupDao.getNotMyGroups(currentUser.getId());
    }

    public void addGroup(String name, String text, int category, boolean isOpen) {
        if (name == null) {
            throw new IllegalArgumentException("Empty fields");
        } else {
            Group newGroup = new Group();
            newGroup.setName(name);
            newGroup.setCategory(category);
            newGroup.setDescription(text);
            newGroup.setOpen(isOpen);
            newGroup.setAdmin(currentUser.getId());
            groupDao.addGroup(newGroup);
        }
    }

    public String getCategoryNameById(int id) {
        for(GroupCategories cat : GroupCategories.values()) {
            if(cat.getCategory() == id) {
                return cat.getText();
            }
        }
        return null;
    }
}
