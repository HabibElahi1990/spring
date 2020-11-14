package junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.annotationConfig.AppConfig;
import spring.annotationConfig.DBConnection;
import spring.annotationConfig.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class EmployeeTest {

    /*
    created is Done!
    inserted is Done!
    Employee{id=1, name='Habib', sal=452.0}
     */
    static Employee employee;
    static Connection connection;

    @BeforeClass
    public static void initConnection() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DBConnection dbConnection = context.getBean(DBConnection.class);
        dbConnection.initialConnection();
        connection = dbConnection.getConnection();
        employee = context.getBean(Employee.class);

    }


    @AfterClass
    public static void destroyConnection() {
        assertNotNull("connection is null", connection);
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createPerson() {
        try {
            String query = "create table Employee (id number(19)," +
                    "name varchar(512) ," +
                    "sal number(10))";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            assertNotNull("preparedStatement is null ", preparedStatement);
            preparedStatement.execute();
            preparedStatement.close();
            System.out.println("created is Done!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertPerson() {
        String query = "insert into Employee (id,name,sal) values(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Habib");
            preparedStatement.setDouble(3, 452.4D);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("inserted is Done!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectPerson() {
        String query = "select * from Employee";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
                System.out.println(employee.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
