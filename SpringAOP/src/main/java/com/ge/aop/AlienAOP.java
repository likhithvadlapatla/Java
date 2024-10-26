package com.ge.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AlienAOP {

    /*
    Method Signature:
    public void afterAdvice(JoinPoint joinPoint)
    This is a public method, meaning it can be accessed from anywhere in your application. It returns void, which means it doesn't return any value. The method name afterAdvice is arbitrary; you can name it whatever you like, but it should be meaningful to describe what the method does.

    The Pointcut Expression:
    "execution(* com.ge.controller.AlienController.*(..))"
    execution(...): This is a pointcut designator in Spring AOP that matches method execution join points. It specifies which methods should be intercepted.
    *: This wildcard matches any method return type.
    com.ge.controller.AlienController: This specifies the fully qualified name of the class. In this case, it is targeting the AlienController class in the com.ge.controller package.
    .*(..):
    The * after . matches any method name within the AlienController class.
    The (..) matches any arguments (any number and any type) passed to the method.

    Pointcut Expression: The pointcut expression in Spring AOP defines the set of methods where the advice (like afterAdvice) should be applied. This expression can match one or more methods in your application.
    Method Interception: When any of these matched methods are executed, Spring AOP intercepts the method call. After the method execution, the corresponding advice method is triggered.
    JoinPoint Information: The JoinPoint object provided to the advice method (like afterAdvice) contains details about only the specific method that was intercepted at that particular time—not all methods matched by the pointcut.

    Pointcut Definition: The pointcut expression execution(* com.ge.controller.AlienController.*(..)) selects all methods in the AlienController class.
    JoinPoint Usage: When a method in AlienController is executed, the JoinPoint provides details about the method (e.g., its name and parameters) and allows the advice to perform operations such as logging or modifying behavior.
    In essence, the pointcut tells Spring AOP where to apply the advice, and the joinpoint provides what is happening at that point (i.e., the specifics of the method being intercepted).

    Details Provided by Signature
    Method Name: The name of the method being executed.
    Return Type: The return type of the method.
    Parameters: The types of the parameters the method takes (though not directly provided by getSignature() but inferred from the context).
     */
    @After(value = "execution(* com.ge.controller.AlienController.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("Response Came from Controller's "+ joinPoint.getSignature()+" at "+ LocalDateTime.now());
    }

    @Before(value = "execution(* com.ge.service.AlienServiceImpl.*(..))")
    public void beforeAdviceService(JoinPoint joinPoint){
        System.out.println("Response Came from Service's "+ joinPoint.getSignature()+" at "+ LocalDateTime.now());
    }

    @After(value = "execution(* com.ge.service.AlienServiceImpl.*(..))")
    public void afterAdviceService(JoinPoint joinPoint){
        System.out.println("Response Came from Service's "+ joinPoint.getSignature()+" at "+ LocalDateTime.now());
    }

    @AfterThrowing(value = "execution(* com.ge.service.AlienServiceImpl.*(..))",throwing = "exception")
    public void afterAdviceService(JoinPoint joinPoint, Exception exception){
        System.out.println("Response Came from Service's"+ joinPoint.getSignature()+" at "+ LocalDateTime.now());
    }
}
