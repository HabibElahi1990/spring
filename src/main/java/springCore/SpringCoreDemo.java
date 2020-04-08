package springCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCoreDemo {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person.toString());

        person = (Person) context.getBean("person2");
        System.out.println(person.toString());

        Person.NestedClass nestedClass= (Person.NestedClass) context.getBean("nested");
        System.out.println(nestedClass.getId());

        Person person3 = (Person) context.getBean("person3");
        System.out.println(person3.toString());

        Student student= (Student) context.getBean("student");
        System.out.println(student.toString());
    }
}
