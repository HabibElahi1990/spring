package springCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCoreDemo {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person.toString());//Person{firstName='Habib', lastName='Elahi'}
        System.out.println(person.getPersonType());//{1=individual person, 2=corporate person, 3=null}

        person = (Person) context.getBean("person2");
        System.out.println(person.toString());//Person{firstName='Habib', lastName='Elahi'}

        Person.NestedClass nestedClass= (Person.NestedClass) context.getBean("nested");
        System.out.println(nestedClass.getId());//100

        Person person3 = (Person) context.getBean("person3");
        System.out.println(person3.toString());//Person{firstName='Ali', lastName='Elahi'}

        Student student= (Student) context.getBean("student");
        System.out.println(student.toString());//Student{person=Person{firstName='Habib', lastName='Elahi'}book=Book{name='Math', unit=4}, nationalCode=11900}

        University university= (University) context.getBean("university");
        System.out.println(university.toString());
        //University{student=Student{person=Person{firstName='Habib', lastName='Elahi'}book=Book{name='Math', unit=4}, nationalCode=11900}, universityName='Test'}

        Province province= (Province) context.getBean("province");
        System.out.println(province.toString());
        //Province{id=1, name='Isfahan', cityList=[City{id=1, name='Isfahan'}, City{id=2, name='Shahreza'}, City{id=3, name='Semirom'}, City{id=4, name='Dehaghan'}]}

        BeanOne beanOne = (BeanOne) context.getBean("beanOne");
        beanOne.doSomthing();
        //BeanTwo Initialized
        //BeanOne Initialized
        //Inside doSomthing() method of BeanOne
        //Inside doSomthing() method of BeanTwo
    }
}
