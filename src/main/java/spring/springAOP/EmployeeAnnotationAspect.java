package spring.springAOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAnnotationAspect {

    @Before("@annotation(spring.springAOP.Loggable)")
    public void beforeAdvice() {
        System.out.println("Executing beforeAdvice!!");
    }


    @After("@annotation(spring.springAOP.Loggable)")
    public void afterAdvice() {
        System.out.println("Executing afterAdvice!!");
    }


    @AfterReturning(pointcut = "execution(* getName())", returning = "returnName")
    public void afterReturningAdvice(String returnName) {
        System.out.println("Object.gerName =" + returnName);
    }



    @Pointcut("execution(* toString())")
    public void pointCutMethod() {
    }

    @Around(value = "pointCutMethod()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before Around Method");
        Object obj = joinPoint.proceed();
        System.out.println("after Around Method");
        return obj;
    }
}
