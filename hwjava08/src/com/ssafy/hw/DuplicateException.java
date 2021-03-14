package com.ssafy.hw;

public class DuplicateException extends Exception {

	public DuplicateException() {
		super("이미 존재하는 상품 입니다.");
	}

	public DuplicateException(String message) {
		super(message);
	}

}
