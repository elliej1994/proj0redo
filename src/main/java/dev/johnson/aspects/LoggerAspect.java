package dev.johnson.aspects;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {

    static int requestCounter = 0;

    public static void logCounter(){
        requestCounter++;
        System.out.println("The total amount of requests is "+ requestCounter);

    }

}
