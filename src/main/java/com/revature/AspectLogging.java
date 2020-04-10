package com.revature;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogging {
	
	private static final Logger LOGGER = LogManager.getLogger(AspectLogging.class);
	
	@After("(execution(* com.revature.controllers.UserController.*(..)))")
	public void logUserControllerAction() {
		
		LOGGER.info("method in User Controller Completed successfully");
		
	}
	
	@After("(execution(* com.revature.controllers.CarController.*(..)))")
	public void logCarControllerAction() {
		
		LOGGER.info("method in Car Controller Completed successfully");
		
	}
	
	

}
