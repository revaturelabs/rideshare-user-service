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
    private Logger log;

    @Around("everything()")
    public synchronized Object log(ProceedingJoinPoint pjp) throws Throwable {
        Object obj = null;
        MethodSignature ms = (MethodSignature) pjp.getSignature();
        Method method = ms.getMethod();
        Parameter[] parameters = method.getParameters();
        Object[] arguments = pjp.getArgs();
        log = Logger.getLogger(method.getDeclaringClass());
        StringBuilder logMessage = new StringBuilder(
            "Method called: "
            +method.getName());
        if (arguments.length > 0) logMessage.append(", with arguments: ");
        for (int i = 0; i < arguments.length; i++ ){
             logMessage.append("  "+parameters[i].getType().getSimpleName()+" "+
                    parameters[i].getName()+" = "+arguments[i]);
         }
         log.trace(logMessage.toString());
         try {
            obj = pjp.proceed();
         } catch (Throwable t) {
            log.error(t.getMessage());
            for(StackTraceElement s : t.getStackTrace()) {
                    log.warn(s);
            }
            throw t;
        }
        // these need to be repeated after the pjp proceeding, or else the class name
        // and method names might be stale
        ms = (MethodSignature) pjp.getSignature();
        method = ms.getMethod();
        log = Logger.getLogger(method.getDeclaringClass());
        log.info(method.getName()+" returned: "+obj);

        return obj;
    }
    // Implemented hooks     

    @Pointcut("execution(public !void org.springframework.data.repository.Repository+.*(..))")
    private void springRepositories() {/* Allows us to see the returns of some Spring repositories */ }
    
    @Pointcut("execution( * com.revature..*.*(..) )")
    private void internal() { /* Our classes in the project are covered by this one */}
    
    @Pointcut("internal() || springRepositories()")
    private void everything() { /* Combination */ }

}
