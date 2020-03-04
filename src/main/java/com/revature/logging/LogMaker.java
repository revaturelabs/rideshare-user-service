package com.revature.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogMaker {

	public static void writeLog(String txt) {
		long millis=System.currentTimeMillis();
		java.util.Date date=new java.util.Date(millis);
		
		String toWrite = date.toString() +" "+ txt;
		
		try {
			writeFile(toWrite);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
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
