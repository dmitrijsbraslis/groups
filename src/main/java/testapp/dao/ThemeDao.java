package testapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import testapp.domain.Theme;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ThemeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Theme> getGroupThemes(int groupId) {
        RowMapper<Theme> rowMapper = new RowMapper<Theme>() {
            @Override
            public Theme mapRow(ResultSet resultSet, int i) throws SQLException {
                Theme result = new Theme();
                result.setId(resultSet.getLong(1));
                result.setText(resultSet.getString(2));
                result.setGroupId(resultSet.getLong(3));
                result.setAuthor(resultSet.getLong(4));
                return result;
            }
        };
        List<Theme> result = this.jdbcTemplate.query("select * from themes where groupId = ?", rowMapper, groupId);
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

    public void addTheme(Theme theme) {
        this.jdbcTemplate.update("insert into themes (text, groupId, author) values(?, ?, ?)",
                new Object[]{theme.getText(), theme.getGroupId(), theme.getAuthor()});
    }
}
