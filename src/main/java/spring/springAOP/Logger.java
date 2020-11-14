package spring.springAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
Aop is a mechanism for improving OOP
in AOP we have a aspect and in the aspect we have many join point like methods
and we have  advice that it reference to logic in each method
and advice is connect to joint points whit pointcut
like Log is aspect and can use log for any methods in kind of mood such as before run methods or after run methods or so forth
then between moods of aspect the  logical method runs
 */
@Aspect
@Component
public class Logger {

    @Before(value = "execution(* spring.springAOP.Person.toString(..))")
    public void beforeRunMethod(JoinPoint joinPoint){
        System.out.println("execution before "+joinPoint.getSignature().getName()+" method in spring.springAOP package");
    }

    @After(value = "execution(* spring.springAOP.Person.toString(..))")
    public void afterRunMethod(JoinPoint joinPoint){
        System.out.println("execution after "+joinPoint.getSignature().getName()+" method in spring.springAOP package");
    }
    @AfterReturning(value = "execution(* spring.springAOP.Person.toString(..))")
    public void afterReturningMethod(JoinPoint joinPoint){
        System.out.println("execution afterReturning "+joinPoint.getSignature().getName()+" method in spring.springAOP package");
    }

    @AfterThrowing(value = "execution(* spring.springAOP.Person.toString(..))")
    public void afterThrowingMethod(JoinPoint joinPoint){
        System.out.println("execution afterThrowingMethod "+joinPoint.getSignature().getName()+" method in spring.springAOP package");
    }

    @Pointcut(value = "execution(* spring.springAOP.Person.toString(..))")
    public void pointCutMethod(){}
    @Around(value = "pointCutMethod()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("execution aroundMethod "+joinPoint.getSignature().getName()+" method in spring.springAOP package");
        return joinPoint.proceed();
    }
}