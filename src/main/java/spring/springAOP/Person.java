package spring.springAOP;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("person2")
public class Person {
    private String firstName;
    private String lastName;
    @Value("#{29}")
    private Integer age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
