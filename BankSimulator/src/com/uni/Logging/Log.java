package com.uni.Logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {

	public static void clearLog()
	{
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter("data/log.txt"));
			writer.write("");
			writer.close();
			}
		catch(IOException e)
		{
			System.out.println("Error Clearing Log : " + e.getMessage());
		}
	}
	public static void writeMessage(String message){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter("data/log.txt", true));
			writer.write(message + '\n');
			writer.close();
			}
		catch (IOException e)
		{
			System.out.println("IO ERROR : " + e.getMessage());
		}
		
	}
	
}
