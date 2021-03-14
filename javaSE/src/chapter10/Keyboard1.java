package chapter10;

import java.io.IOException;

public class Keyboard1 {

	public static void main(String[] args) throws IOException {
		int data;
		
		do {
			data = System.in.read();
			if(data != '\r' && data != '\n') {
				System.out.println((char)data);				
			}
		}while(data !='x' && data != -1);
	}

}
