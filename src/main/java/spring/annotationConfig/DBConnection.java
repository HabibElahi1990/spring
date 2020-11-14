package spring.annotationConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@PropertySource({"classpath:dataSource.properties"})
public class DBConnection {
    @Value("${db_driver}")
    private String dbDriver;
    @Value("${db_connection}")
    private String dbConnection;
    private String dbUser;
    @Value("${db_password}")
    private String dbPassword;
    private Connection connection;

    public DBConnection() {
    }

    public Connection getConnection() {
        return this.connection;
    }


    public void initialConnection() {
        try {
            Class.forName(this.dbDriver);
            this.connection = DriverManager.getConnection(this.dbConnection, this.dbUser, this.dbPassword);
        } catch (ClassNotFoundException | SQLException e) {
           e.printStackTrace();
        }

    }

    public String getDbDriver() {
        return this.dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public String getDbConnection() {
        return this.dbConnection;
    }

    public void setDbConnection(String dbConnection) {
        this.dbConnection = dbConnection;
    }

    public String getDbUser() {
        return this.dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return this.dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    @Override
    public String toString() {
        return "DBConnection{" +
                "dbDriver='" + dbDriver + '\'' +
                ", dbConnection='" + dbConnection + '\'' +
                ", dbUser='" + dbUser + '\'' +
                ", dbPassword='" + dbPassword + '\'' +
                '}';
    }
}
