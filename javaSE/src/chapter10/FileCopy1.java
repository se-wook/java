package chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy1 {

	public static void main(String[] args) {
//		String readFile = "src/Chapter10/FileCopy1.java";
		String readFile = "c:/ssafy/java-workspace.zip";
		String saveFile = "res/copy2.zip";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(readFile);
			fos = new FileOutputStream(saveFile);
			
			int read;
			byte[] buf = new byte[1024];

			while((read = fis.read(buf)) != -1) {
				fos.write(buf, 0, read);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fos != null) {try {fos.close();} catch (Exception e) {}}
			if(fis != null) {try {fis.close();} catch (Exception e) {}}
		}
	}

}
