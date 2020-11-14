package spring.springExpressionLanguage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by h.elahi on 11/19/2018.
 */
@Component
// import file config app.properties and use values
@PropertySource("classpath:app.properties")
public class OperatorsClass {

    //Arithmetic Operators

    @Value("#{10}")//10
    private Integer number;
    @Value("#{'Habib'}")//Habib
    private String str;
    @Value("#{10/5}")//2
    private Double divide;
    @Value("#{10/4}")//2
    private Double mode;
    @Value("#{10*2}")//20
    private Long mul;

    //Relational and Logical Operators

    @Value("#{10 == 10}") // true
    private Boolean equal;
    @Value("#{1 < 1}") // false
    private boolean lessThan;
    @Value("#{!false}") // true
    private boolean notTrue;

    //Conditional Operators

    @Value("#{10 > 5 ? '10' : '5'}") // "10"
    private String conditionTernary;

    //Regex
    @Value("#{'100abcd' matches '\\d+' }") // false
    private boolean validNumericStringResult;


    @Value("${salary}") // 31000
    private Integer salary;

    @Value("#{'${integerList}'.split(',')}")
    private List<Integer> integerList;


    public List<Integer> getIntegerList() {
        return integerList;
    }

    @Override
    public String toString() {
        return "OperatorsClass{" +
                "number=" + number +
                ", str='" + str + '\'' +
                ", divide=" + divide + "\n" +
                ", mode=" + mode +
                ", mul=" + mul +
                ", equal=" + equal + "\n" +
                ", lessThan=" + lessThan +
                ", notTrue=" + notTrue +
                ", conditionTernary='" + conditionTernary + '\'' + "\n" +
                ", validNumericStringResult=" + validNumericStringResult +
                ", salary=" + salary +
                '}';
    }
}
