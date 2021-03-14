package chapter06.sub;

public interface Trans {
	int INIT = 10;	// 컴파일시 public static final 로 선언됨.
	void start();	// 컴파일시 public abstract 가 추가됨.
	void stop();	// 컴파일시 public abstract 가 추가됨.
}
