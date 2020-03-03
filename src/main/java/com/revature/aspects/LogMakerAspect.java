package com.revature.aspects;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

public class LogMakerAspect {

	@Around("logPointCut()")
	public void writeLog(ProceedingJoinPoint pjp) {
		
		long millis=System.currentTimeMillis();
		java.util.Date date=new java.util.Date(millis);
		
		String toWrite = date.toString() + pjp.getSignature() + "Argument(s): ";
		
		Object[] arguements = pjp.getArgs();
		for (Object o:arguements) {
			toWrite += o;
		}

		try {
			writeFile(toWrite);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Pointcut("@annotation(com.revature.aspects.LogIt)")
	private void logPointCut() {};
	
	public static void writeFile(String txt) throws IOException {
		String file_path;
		boolean append_to_file = true;
		
		file_path = System.getProperty("user.dir")+"\\src\\main\\resources\\log.txt";

		FileWriter write = new FileWriter( file_path , append_to_file);
		PrintWriter print_line = new PrintWriter( write );
		print_line.printf("%s" + "%n", txt);
		
		print_line.close();
	}
}
