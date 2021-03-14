package com.ssafy.ws;

public class QuantityException extends Exception {

	public QuantityException() {
		super("수량이 부족합니다.");
	}

	public QuantityException(String arg0) {
		super(arg0);
	}
	
}
