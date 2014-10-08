package lv.k2611a.testapp.services;

import org.springframework.stereotype.Service;

import lv.k2611a.testapp.domain.User;

/**
 * @author <a href="mailto:kirill.afanasjev@odnoklassniki.ru">Kirill Afanasjev</a>
 */
@Service
public class UserService {
    public User getUserById(Long userId) {
        if (userId == 1) {
            User user = new User();
            user.setName("Kirill Afanasjev");
            return user;
        }
        return null;
    }
}
