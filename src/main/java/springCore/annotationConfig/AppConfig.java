package springCore.annotationConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import springCore.springExpressionLanguage.OperatorsClass;

@Configuration
@ComponentScan(basePackages = "springCore",basePackageClasses = {OperatorsClass.class})
public class AppConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    @Scope("singleton")
    @Description("bean is belong to Person class")
    public Person person() {
        return new Person();
    }



    //define @Profile and then for every mood can use from appropriate condition
    // dev or prod
    @Bean(name="dataSource")
    @Profile("dev")
    public DataSource getDevDataSource() {
        return new DevDatabaseUtil();
    }

    @Bean(name="dataSource")
    @Profile("prod")
    public DataSource getProdDataSource() {
        return new ProductionDatabaseUtil();
    }

    @Value("${db_user}")
    private String dbUser;

    // in order to dbConnection1 use  @Primary dbUser =""+dbConnection1
    @Bean
    @Primary
    public DBConnection dbConnection1(){
        DBConnection dbConnection=new DBConnection();
        dbConnection.setDbUser(dbUser+" dbConnection1 ");
        return dbConnection;
    }

    @Bean
    public DBConnection dbConnection2(){
        DBConnection dbConnection=new DBConnection();
        dbConnection.setDbUser(dbUser+" dbConnection2 ");
        return dbConnection;
    }
}
