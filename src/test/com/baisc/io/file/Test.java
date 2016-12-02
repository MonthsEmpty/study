package test.com.baisc.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Test {

	public static void main(String[] args) throws IOException {
		String path = "d:/test.txt";
		File file = new File(path);
		File file1 = new File("d:/test1.txt");
		file.renameTo(file1);
		/*InputStream inputStream = new FileInputStream(file);
		byte[] b = new byte[256];
		inputStream.read(b);
		System.out.println(new String(b));*/
	}
}
