package com.revature.aspects;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 *
 * @author May Love
 */

@Component
@Aspect
public class Logging {

    /* since there may be multiple threads calling methods at the same time, tracking 
    provides a unique identifier, so it's possible to see which returns correspond to
    which method calls without having to slow down the data processing with
    the synchronized keyword */
    private int tracking; 

    @Around("everything()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        Object obj = null;
        int logTracking = tracking++;
        MethodSignature ms = (MethodSignature) pjp.getSignature();
        Method method = ms.getMethod();
        Parameter[] parameters = method.getParameters();
        Object[] arguments = pjp.getArgs();
        Logger log = Logger.getLogger(method.getDeclaringClass());
        StringBuilder logMessage = new StringBuilder("(Method call "+logTracking+") "+
            "Method called: "
            +method.getName());
        if (arguments.length > 0) logMessage.append(", with arguments: ");
        for (int i = 0; i < arguments.length; i++ ){
             logMessage.append("  "+parameters[i].getType().getSimpleName()+" "+
                    parameters[i].getName()+" = "+arguments[i]);
         }
        log.info(logMessage);
         try {
            obj = pjp.proceed();
         } catch (Throwable t) {
            log.error(t.getMessage());
            for(StackTraceElement s : t.getStackTrace()) {
                    log.warn(s);
            }
            throw t;
        }
        log.info("(Method call "+logTracking+") "+method.getName()+" returned: "+obj);

        return obj;
    }
    // Implemented hooks     
    
    @Pointcut("execution(* com.revature.repositories.*Repository+.*(..))")
    private void repositories() {/* Allows us to see the returns of some Spring repositories */ }
    
    @Pointcut("execution( * com.revature..*.*(..) )")
    private void internal() { /* Our classes in the project are covered by this one */}
    
    @Pointcut("internal() || repositories()")
    private void everything() { /* Combination */ }

}
