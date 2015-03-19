package testapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testapp.dao.UserDao;
import testapp.domain.User;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements Serializable {

    @Autowired
    UserDao userDao;

    public void addUser(String name, String surname, String login, String password) {
        if (name == null || surname == null || login == null || password == null) {
            throw new IllegalArgumentException("Empty fields");
        } else {
            User user = new User();
            user.setName(name);
            user.setSurname(surname);
            user.setLogin(login);
            user.setPassword(password);
            userDao.addUser(user);
        }
    }

    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }
}
