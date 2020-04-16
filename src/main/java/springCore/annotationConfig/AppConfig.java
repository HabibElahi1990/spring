package springCore.annotationConfig;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "springCore")
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


}
