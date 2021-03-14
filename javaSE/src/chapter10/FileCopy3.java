package chapter10;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * char 
 *  - 문자 전용 입출력
 *  - 문자가 아닌 데이터를 입출력하면 데이터가 손상됨.
 *  -  
 *
 */

public class FileCopy3 {

	public static void main(String[] args) {
		String readFile = "c:/ssafy/logo.jpg";
		String saveFile = "res/copy4.jpg";
		
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(readFile);
			fw = new FileWriter(saveFile);
			
			int len;
			char[] buf = new char[1024];
			while((len=fr.read(buf))!= -1) {
				fw.write(buf,0,len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fr != null) {try {fr.close();} catch (Exception e) {}}
			if(fw != null) {try {fw.close();} catch (Exception e) {}}
		}
	}

}
