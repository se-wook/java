package com.ssafy.ws;

public class ISBNNotFoundException extends Exception{
	public ISBNNotFoundException() {
		super("해당 ISBN이 존재하지 않습니다.");
	}
	public ISBNNotFoundException(String message) {
		super(message);
	}
	
}
