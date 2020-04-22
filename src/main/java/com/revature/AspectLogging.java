package com.revature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.revature.beans.Car;
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
	 * The method below logs the user that logs in. If there are any errors these
	 * will be logged as well.
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
	 * These return methods will log the HTTP response entities of all the
	 * controllers.
	 */

	@Pointcut("execution(* com.revature.controllers.CarController.*(..))" + 
			"execution(* com.revature.controllers.UserController.*(..)" + 
			"execution(* com.revature.controllers.LoginController.*(..))" + 
			"execution(* com.revature.controllers.BatchController.*(..))" + 
			"execution(* com.revature.controllers.AdminController.*(..))")
	public void allControllers() {}
	
	@AfterReturning(pointcut = "allControllers()", returning = "retVal")
	public void logCarHttpStatusResponse(ResponseEntity<Car> retVal) {

		LOGGER.info("Status Code: " + retVal.getStatusCode() + " Message: " + retVal.getStatusCode().getReasonPhrase());

	}

	@AfterReturning(pointcut = "allControllers()", returning = "retVal")
	public void logUserHttpStatusResponse(ResponseEntity<User> retVal) {

		LOGGER.info("Status Code: " + retVal.getStatusCode() + " Message: " + retVal.getStatusCode().getReasonPhrase());

	}

	
	/*
	 * Everytime I use a method with "PostMapping" annotation I want to get the request body
	 */
	
	@Pointcut("execution(* com.revature.controllers.CarController.*(.., @org.springframework.web.bind.annotation.RequestBody (*), ..))" + 
	"execution(* com.revature.controllers.UserController.*(.., @org.springframework.web.bind.annotation.RequestBody (*), ..))" + 
	"execution(* com.revature.controllers.LoginController.*(.., @org.springframework.web.bind.annotation.RequestBody (*), ..))" + 
	"execution(* com.revature.controllers.BatchController.*(.., @org.springframework.web.bind.annotation.RequestBody (*), ..))" + 
	"execution(* com.revature.controllers.AdminController.*(.., @org.springframework.web.bind.annotation.RequestBody (*), ..))")
	  public void executeController() {}


	  @Pointcut(
	      "@annotation(org.springframework.web.bind.annotation.RequestMapping) || " +
	      "@annotation(org.springframework.web.bind.annotation.PostMapping) || " +
	      "@annotation(org.springframework.web.bind.annotation.PutMapping) ||" +
	      "@annotation(org.springframework.web.bind.annotation.ExceptionHandler)"
	    )
	  public void logRequestMapping() {}

	  @Before(
	    "logRequestMapping() &&" +
	    "executeController()"
	  )
	  public void logRequestBody(JoinPoint thisJoinPoint) {
	    MethodSignature methodSignature = (MethodSignature) thisJoinPoint.getSignature();
	    Annotation[][] annotationMatrix = methodSignature.getMethod().getParameterAnnotations();
	    int index = -1;
	    for (Annotation[] annotations : annotationMatrix) {
	      index++;
	      for (Annotation annotation : annotations) {
	        if (!(annotation instanceof RequestBody))
	          continue;
	        Object requestBody = thisJoinPoint.getArgs()[index];
	        LOGGER.info("Package Location of method called: " + methodSignature.getDeclaringTypeName());
	        LOGGER.info("Name of method: " + methodSignature.getName());
	        LOGGER.info("Request Body = " + requestBody);
	        
	        
	      }
	    }
	  }

}
