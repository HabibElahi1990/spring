package spring.springExpressionLanguage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.annotationConfig.AppConfig;

public class SpELDemo {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        OperatorsClass operatorsClass=context.getBean(OperatorsClass.class);
        System.out.println(operatorsClass.toString());

        /*
        OperatorsClass{number=10, str='Habib', divide=2.0
        , mode=2.0, mul=20, equal=true
        , lessThan=false, notTrue=true, conditionTernary='10'
        , validNumericStringResult=false, salary=31000}
         */

        System.out.println(operatorsClass.getIntegerList());//[10, 20, 30]
    }
}
