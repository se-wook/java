package com.ssafy.model.dto;

public class DuplicateException extends RuntimeException {

	public DuplicateException() {
		super("동일한 사원번호가 있습니다.");
	}
	public DuplicateException(String msg) {
		super(msg);
	}
	
}
