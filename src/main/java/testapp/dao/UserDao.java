package testapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import testapp.domain.User;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserByLogin(String login) {
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User result = new User();
                result.setId(resultSet.getLong(1));
                result.setLogin(resultSet.getString(2));
                result.setPassword(resultSet.getString(3));
                result.setName(resultSet.getString(4));
                result.setSurname(resultSet.getString(5));
                return result;
            }
        };
        List<User> result = this.jdbcTemplate.query("select * from user where login = ?", rowMapper, login);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    public void addUser(User user) {
        this.jdbcTemplate.update("insert into user (login, password, name, surname) values(?, ?, ?, ?)", new String[]{user.getLogin(), user.getPassword(), user.getName(), user.getSurname()});
    }
}
