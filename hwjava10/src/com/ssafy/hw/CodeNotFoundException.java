package com.ssafy.hw;

public class CodeNotFoundException extends Exception {

	public CodeNotFoundException() {
		super("상품 번호가 존재하지 않습니다.");
	}

	public CodeNotFoundException(String message) {
		super(message);
	}

}
