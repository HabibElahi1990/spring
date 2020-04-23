package springCore.springAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAopDemo {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = context.getBean(Person.class);
        person.setFirstName("Habib");
        person.setLastName("Elahi");
        System.out.println(person.toString());
    }
}
