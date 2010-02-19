package com.uni.Exceptions;

public class NonExistantAccountException extends Exception{

	public NonExistantAccountException(){
		super("Account does not exist");
	}
	
}
