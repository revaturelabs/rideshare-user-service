package com.revature;

import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.revature.beans.User;

@Aspect
@Component
public class AspectLogging {

	/*
	 * This class is an Aspect class using AOP to Log information to the console.
	 * 
	 */

	/*
	 *  
	 */
	private static final Logger LOGGER = LogManager.getLogger(AspectLogging.class);

	

	/*
	 * The method below logs the user that logs in.
	 * If there are any errors these will be logged as well. 
	 */

	@AfterReturning(pointcut = "execution(* com.revature.controllers.LoginController.login(..))", returning = "retVal")
	public void logUser(Map<String, Set<String>> retVal) {

		if (retVal.get("userNotFound") != null) {
			for (Map.Entry<String, Set<String>> entry : retVal.entrySet()) {
				LOGGER.warn(entry.getValue());
			}
		} else if (retVal.get("userName") != null) {

			for (Map.Entry<String, Set<String>> entry : retVal.entrySet()) {
				LOGGER.warn(entry.getValue());
			}

		} else if (retVal.get("name") != null) {

			LOGGER.info(retVal.get("name") + "logged in ");
		}
	}
	
	
	/*
	 * this method logs the errors the user encounters while trying to sign up
	 */

	@AfterReturning(pointcut = "execution(* com.revature.controllers.UserController.addUser(..))", returning = "retVal")
	public void CreateUserErrors(Map<String, Set<String>> retVal) {

		for (Map.Entry<String, Set<String>> entry : retVal.entrySet()) {
			LOGGER.warn(entry.getValue());
		}

	}

	/*
	 * The next few methods log the location of the method used immediately after it is used.
	 * Someone looking at this code and trying to evaluate it could find what they are look for quicker this way. 
	 */
	@Around("execution(* com.revature.controllers.UserController.*(..))")
    public void logUserMethods(ProceedingJoinPoint jp) throws Throwable {

        LOGGER.info("Package: com.revature.controllers		Class: UserController 		Method: " + jp.getSignature().getName());
        jp.proceed();	
        
    }
	
	@Around("execution(* com.revature.controllers.CarController.*(..))")
    public void logCarMethods(ProceedingJoinPoint jp) throws Throwable {

        LOGGER.info("Package: com.revature.controllers		Class: CarController 		Method: " + jp.getSignature().getName());
        jp.proceed();
        
    }
	
	@Around("execution(* com.revature.controllers.LoginController.*(..))")
    public void logLoginMethod(ProceedingJoinPoint jp) throws Throwable {

        LOGGER.info("Package: com.revature.controllers		Class: LoginController 		Method: " + jp.getSignature().getName());
        jp.proceed();
        
    }
	
	@Around("execution(* com.revature.controllers.BatchController.*(..))")
    public void logBatchMethods(ProceedingJoinPoint jp) throws Throwable {

        LOGGER.info("Package: com.revature.controllers		Class: BatchController 		Method: " + jp.getSignature().getName());
        jp.proceed();
        
    }
	
	@Around("execution(* com.revature.controllers.AdminController.*(..))")
    public void logAdminMethods(ProceedingJoinPoint jp) throws Throwable {

        LOGGER.info("Package: com.revature.controllers		Class: AdminController 		Method: " + jp.getSignature().getName());
        jp.proceed();
        
    }
	
	
	

}
