package com.ge.aop;

import com.ge.model.Task;
import com.ge.model.User;
import com.ge.service.ITaskService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
public class TaskAOP {

    @Autowired
    private ITaskService service;

    @Before(value = "execution(* com.ge.api.TaskController.createTask(..)) || " +
            "execution(* com.ge.api.TaskController.updateTask(..)) ||" +
            "execution(* com.ge.api.TaskController.deleteTask(..))")
    public void logTaskActivity(JoinPoint jointPoint){
        String methodName = jointPoint.getSignature().getName();
        Object args[] = jointPoint.getArgs();
        System.out.println("Executing: "+methodName+" with arguments: "+ Arrays.toString(args));
    }

    /*
        joinPoint.proceed() call in the code is used in the context of an @Around advice in Spring AOP. It allows the aspect to continue the execution of the target method and return its result.
        Before proceed(): Any code you place before the proceed() call is executed before the target method is invoked. For example, "Transaction started" is printed before the target method (updateTask() in this case) runs.
        proceed(): This calls the target method (like updateTask()) and allows it to execute. If proceed() is not called, the target method will never run, and the advice would effectively block it.
        After proceed(): Any code you place after the proceed() call runs after the target method completes. For example, "Transaction committed" is printed after the method returns successfully.
        Return Value: The result of proceed() is the return value of the target method (e.g., if updateTask() returns a value, it is captured in result). This value must be returned from the advice, so the caller of the target method receives it as expected.
     */
    @Around("execution(* com.ge.api.TaskController.updateTask(..)) || " +
            "execution(* com.ge.api.TaskController.deleteTask(..))")
    public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Transaction Started.");
        try{
            Object result = joinPoint.proceed();
            System.out.println("Transaction Committed.");
            return result;
        }
        catch(Exception e){
            System.out.println("Transaction rolled back");
            throw e;
        }
    }

    /*
        @AfterReturning: Executes the advice after the method successfully completes and returns a result. If your intention is to handle notifications only after the method executes without errors (for instance, successfully checking task deadlines), this is the right choice.
        @After: Executes the advice after the method completes, whether it completed successfully or threw an exception. So, if the checkTaskDeadlines() method fails (throws an exception), the notification logic in @After would still run, which might not be desirable.

        In the context of map(), Task::getUser refers to a method that takes a Task instance and returns its associated User. It's equivalent to writing a lambda like this: task -> task.getUser()
     */
    @AfterReturning(pointcut = "execution(* com.ge.api.TaskController.findOverdueTask(..))", returning="result")
    public void handleNotifications(List<Task> result){
        if(!result.isEmpty()){
            List<User> user = result.stream()
                    .map(Task::getUser)
                    .distinct()
                    .toList();
            user.forEach(users ->service.sendCustomerNotification(users.getId(),"Task is overdue"));
            }
        }
}
