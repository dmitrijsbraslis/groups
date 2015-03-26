package testapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import testapp.domain.Group;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GroupDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addGroup(Group group) {
        this.jdbcTemplate.update("insert into groups (name, description, open, category, admin) values(?, ?, ?, ?, ?)",
                new Object[]{group.getName(), group.getDescription(), group.isOpen(), group.getCategory(), group.getAdmin()});
    }

    public Group getGroupNameById(int groupId) {
        RowMapper<Group> rowMapper = new RowMapper<Group>() {
            @Override
            public Group mapRow(ResultSet resultSet, int i) throws SQLException {
                Group result = new Group();
                result.setName(resultSet.getString(1));
                return result;
            }
        };
        List<Group> result = this.jdbcTemplate.query("select name from groups where id = ?", rowMapper, groupId);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    RowMapper<Group> rowMapperAll = new RowMapper<Group>() {
        @Override
        public Group mapRow(ResultSet resultSet, int i) throws SQLException {
            Group result = new Group();
            result.setId(resultSet.getInt(1));
            result.setName(resultSet.getString(2));
            result.setDescription(resultSet.getString(3));
            result.setOpen(resultSet.getBoolean(4));
            result.setCategory(resultSet.getInt(5));
            result.setAdmin(resultSet.getInt(6));
            return result;
        }
    };

    public List<Group> getGroupsByCategory(int catalogId) {
        List<Group> result = this.jdbcTemplate.query("select * from groups where category = ?", rowMapperAll, catalogId);
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

    public List<Group> getUserGroups(long userId) {
        List<Group> result = this.jdbcTemplate.query("select * from groups where admin = ?", rowMapperAll, userId);
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

    public List<Group> getNotMyGroups(long userId) {
        List<Group> result = this.jdbcTemplate.query("select * from groups where admin != ?", rowMapperAll, userId);
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }
}
