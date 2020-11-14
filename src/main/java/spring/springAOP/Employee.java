package spring.springAOP;

import org.springframework.stereotype.Component;

@Component("employee")
public class Employee {

    private String name;

    public String getName() {
        return name;
    }

    @Loggable
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
