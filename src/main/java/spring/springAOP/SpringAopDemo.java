package spring.springAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAopDemo {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = context.getBean(Person.class);
        person.setFirstName("Habib");
        person.setLastName("Elahi");
        System.out.println(person.toString());

        /*
        execution aroundMethod toString method in spring.springAOP package
        execution before toString method in spring.springAOP package
        execution after toString method in spring.springAOP package
        execution afterReturning toString method in spring.springAOP package
        Person{firstName='Habib', lastName='Elahi', age=29}
         */


        Employee employee=context.getBean(Employee.class);
        employee.setName("Habib");
        employee.getName();
        System.out.println(employee.toString());

        /*
        Executing beforeAdvice!!
Executing afterAdvice!!
Object.gerName =Habib
before Around Method
after Around Method
Employee{name='Habib'}
         */
    }
}
