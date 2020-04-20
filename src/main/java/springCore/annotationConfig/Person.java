package springCore.annotationConfig;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
public class Person {

    private Long id;
    private String code;
    private Integer personType;


    public Person() {
        System.out.println("person constructor");
    }

    public void initMethod(){
        System.out.println("person init method");
    }

    public void destroyMethod(){
        System.out.println("person destroy method");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPersonType() {
        return personType;
    }

    public void setPersonType(Integer personType) {
        this.personType = personType;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("person PostConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("person PreDestroy");
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", personType=" + personType +
                '}';
    }
}
