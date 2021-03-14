package com.ssafy.model.dto;

public class BookException extends RuntimeException {
	public BookException() {
		super("Book 정보를 처리중 오류 발생");
	}
	public BookException(String msg) {
		super(msg);
	}
}
