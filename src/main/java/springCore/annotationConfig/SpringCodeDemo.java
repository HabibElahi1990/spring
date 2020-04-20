package springCore.annotationConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCodeDemo {

    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        Person person=context.getBean(Person.class);
        person.setId(1L);
        person.setCode("931009");
        person.setPersonType(1);
        System.out.println(person.toString());
        //1) person constructor
        //2) person init method
        //3) Person{id=1, code='931009', personType=1}
        //4) person destroy method

        Contract contract=context.getBean(Contract.class);
        Template template=context.getBean(Template.class);
        template.setTemplateNumber("1398/10000/10");
        contract.setContractNumber("1398/500/10");
        System.out.println(contract.toString());
        //Contract{contractNumber='1398/500/10', template=Template{templateNumber='1398/10000/10'}}

        ((AnnotationConfigApplicationContext) context).close();



    }
}
