package testapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import testapp.domain.Group;
import org.springframework.stereotype.Service;
import testapp.domain.GroupCategories;
import testapp.domain.User;
import testapp.session.CurrentUser;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.*;

@Service
public class GroupService implements Serializable {
    public long groupId = 1L;
    public Map<Long, Group> groups = new HashMap<Long, Group>();

    @Autowired
    private CurrentUser currentUser;

    @PostConstruct
    public void restoreGroups() {
        try {
            InputStream file = new FileInputStream("groups.ser");
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            groups = (Map<Long, Group>)input.readObject();
        }
        catch (ClassNotFoundException ex) {
            System.out.println("No class");
        }
        catch (IOException ex) {
            System.out.println("Error");
        }
    }

    @PostConstruct
    public void restoreGroupId() {
        try {
            InputStream file = new FileInputStream("groupId.ser");
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            groupId = (Long)input.readObject();
        }
        catch (ClassNotFoundException ex) {
            System.out.println("No class");
        }
        catch (IOException ex) {
            System.out.println("Error");
        }
    }

    public Group getGroupNameById(long groupID) {
        Group group = new Group();
        group.setName(groups.get(groupID).getName());
        return group;
    }

    public List<Group> getAllGroups() {
        List<Group> allGroups = new ArrayList<Group>();
        for(Map.Entry<Long, Group> entry : groups.entrySet()) {
            allGroups.add(entry.getValue());
        }
        return allGroups;
    }

    public List<Group> getGroupsByCategory(int catalogId) {
        List<Group> catalogGroups = new ArrayList<Group>();
        for(Map.Entry<Long, Group> entry : groups.entrySet()) {
            if (entry.getValue().getCategory() == catalogId) {
                catalogGroups.add(entry.getValue());
            }
        }
        return catalogGroups;
    }

    public List<Group> getMyGroups() {
        List<Group> myGroups = new ArrayList<Group>();
        for(Map.Entry<Long, Group> entry : groups.entrySet()) {
            if (entry.getValue().getUser_id() == currentUser.getId()) {
                myGroups.add(entry.getValue());
            }
        }
        return myGroups;
    }

    public List<Group> getNotMyGroups() {
        List<Group> notMyGroups = new ArrayList<Group>();
        for(Map.Entry<Long, Group> entry : groups.entrySet()) {
            if (entry.getValue().getUser_id() != currentUser.getId()) {
                notMyGroups.add(entry.getValue());
            }
        }
        return notMyGroups;
    }

    public void addGroup(String name, String text, int category, boolean isOpen) {
        Group newGroup = new Group();
        newGroup.setName(name);
        newGroup.setCategory(category);
        newGroup.setDescription(text);
        newGroup.setIs_open(isOpen);
        newGroup.setId(groupId);
        newGroup.setUser_id(currentUser.getId());
        groups.put(groupId, newGroup);
        groupId++;
    }

    public String getCategoryNameById(int id) {
        for(GroupCategories cat : GroupCategories.values()) {
            if(cat.getCategory() == id) {
                return cat.getText();
            }
        }
        return null;
    }

    @PreDestroy
    public void saveGroups() {
        try {
            OutputStream file = new FileOutputStream("groups.ser");
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            output.writeObject(groups);
            output.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @PreDestroy
    public void saveGroupId() {
        try {
            OutputStream file = new FileOutputStream("groupId.ser");
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            output.writeObject(groupId);
            output.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
