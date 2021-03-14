package chapter10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keyboard2 {

	public static void main(String[] args) throws IOException {
		int data;
		BufferedReader br = null;
		InputStreamReader isr = null;
		
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr); //buffer 하고 키보드 하고 연결
			String line;
//			readLine() 라인 구분자를 기준으로 데이터를 읽어서 문자열로 리턴, 못읽은 경우 null 리턴
			while((line = br.readLine())!=null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(br != null) {try {br.close();} catch (Exception e) {}}
			if(isr != null) {try {isr.close();} catch (Exception e) {}}
		}
	}

}
