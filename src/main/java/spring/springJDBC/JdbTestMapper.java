package spring.springJDBC;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbTestMapper implements RowMapper<JDBCTest> {

    public JDBCTest mapRow(ResultSet rs, int rowNum) throws SQLException {
        JDBCTest jdbcTest = new JDBCTest();
        jdbcTest.setId(rs.getLong("id"));
        jdbcTest.setName(rs.getString("name"));
        jdbcTest.setBirthDate(rs.getDate("birthDate"));

        return jdbcTest;
    }

}
