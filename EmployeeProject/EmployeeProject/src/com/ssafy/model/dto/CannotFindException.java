package com.ssafy.model.dto;

public class CannotFindException extends RuntimeException {

	public CannotFindException() {
		super("사원번호에 해당하는 사원을 찾을 수 없습니다.");
	}

	public CannotFindException(String message) {
		super(message);
	}
	
	
}
