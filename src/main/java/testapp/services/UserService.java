package testapp.services;

import org.springframework.stereotype.Service;
import testapp.domain.User;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements Serializable {
    public long userId = 0L;
    public Map<String, User> allUsers = new HashMap<String, User>();

    @PostConstruct
    public void restoreUsers() {
        try {
            InputStream file = new FileInputStream("users.ser");
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            allUsers = (Map<String, User>)input.readObject();
        }
        catch (ClassNotFoundException ex) {
            System.out.println("No class");
        }
        catch (IOException ex) {
            System.out.println("Error");
        }
    }

    @PostConstruct
    public void restoreUserId() {
        try {
            InputStream file = new FileInputStream("userId.ser");
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            userId = (Long)input.readObject();
        }
        catch (ClassNotFoundException ex) {
            System.out.println("No class");
        }
        catch (IOException ex) {
            System.out.println("Error");
        }
    }

    public void addUser(String name, String surname, String login, String password) {
        if (name == null || surname == null || login == null || password == null) {
            throw new IllegalArgumentException("Empty fields");
        } else {
            userId++;
            User user = new User();
            user.setId(userId);
            user.setName(name);
            user.setSurname(surname);
            user.setLogin(login);
            user.setPassword(password);
            allUsers.put(login, user);
        }
    }

    public User getUserByLogin(String login) {
        return allUsers.get(login);
    }

    @PreDestroy
    public void saveUsers() {
        try {
            OutputStream file = new FileOutputStream("users.ser");
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            output.writeObject(allUsers);
            output.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @PreDestroy
    public void saveUserId() {
        try {
            OutputStream file = new FileOutputStream("userId.ser");
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            output.writeObject(userId);
            output.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
