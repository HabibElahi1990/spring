package junit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import spring.springJDBC.DataSourceConfiguration;
import spring.springJDBC.JDBCTest;
import spring.springJDBC.JdbTestMapper;

import java.util.List;

public class SpringJDBCTest {


    private static JdbcTemplate jdbcTemplate;

    @BeforeClass
    public static void setDataSource() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
        jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
    }

    @Test
    public void createTestTable() {
        String sql = "CREATE TABLE JDBC_TEST (" +
                "id number(19) not null ," +
                "name varchar(150) not null ," +
                "birthDate date " +
                ")";
        jdbcTemplate.execute(sql);
    }

    @Test
    public void insetTestTable() {
        StringBuilder stringBuilder = new StringBuilder("insert into JDBC_TEST (id,name,birthDate)")
                .append(" values ").append('(')
                .append(1).append(",'").append("Habib").append("',").append("sysdate").append(')');
        jdbcTemplate.update(stringBuilder.toString());

        stringBuilder = new StringBuilder("insert into JDBC_TEST (id,name,birthDate)")
                .append(" values ").append('(')
                .append(1).append(",'").append("Ali").append("',").append("sysdate-5500").append(')');
        jdbcTemplate.update(stringBuilder.toString());
    }

    @Test
    public void selectTestTable() {
        String sql = "select * from JDBC_TEST";
        List<JDBCTest> jdbcTestList = jdbcTemplate.query(sql, new Object[]{}, new JdbTestMapper());
        jdbcTestList.forEach(n -> System.out.println(n.toString()));
        /*
        JDBCTest{id=1, name='Habib', birthDate=2020-11-04}
        JDBCTest{id=1, name='Ali', birthDate=2005-10-14}
         */
    }

}
