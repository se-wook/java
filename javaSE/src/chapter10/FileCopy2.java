package chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy2 {

	public static void main(String[] args) {
//		String readFile = "src/Chapter10/FileCopy1.java";
		String readFile = "c:/ssafy/java-workspace.zip";
		String saveFile = "res/copy1.zip";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
//			지정한 경로에 file이 없으면 FileNotFoundException 발생
			fis = new FileInputStream(readFile);
//			지정한 경로에 file이 없으면 새로 만들어준다.
			fos = new FileOutputStream(saveFile);
			
			int read;
			/*
			 * -1 은 데이터를 못 읽은 경우
			 * File : EOF
			 * Memory : EOM 
			 * Network : 종료(socket close된 경우)
			 * keyboard : 입력 종료 명령 - Ctrl+z or Ctrl+c
			 * 
			 */
			while((read = fis.read()) != -1) { // EOF 까지 읽겠지
				fos.write(read);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fos != null) {try {fos.close();} catch (Exception e) {}}
			if(fis != null) {try {fis.close();} catch (Exception e) {}}
		}
	}

}
