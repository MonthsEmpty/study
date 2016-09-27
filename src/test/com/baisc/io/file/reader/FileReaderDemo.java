package test.com.baisc.io.file.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderDemo {

	public static void main(String[] args) {
		
		reader2();
	}
	
	public static void reader(){
		File f = new File("G:" + File.separator + "test.txt");
		try {
			char[] c = new char[1024];
			Reader reader = new FileReader(f);
			int len = reader.read(c);
			System.out.println(new String(c, 0, len));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void reader2(){
		File f = new File("G:" + File.separator + "test.txt");
		try {
			char[] c = new char[1024];
			Reader reader = new FileReader(f);
			int i = 0;
			int temp = 0;
			while((temp = reader.read()) != -1){
				c[i] = (char) temp;
				i++;
			}
			System.out.println(new String(c, 0, i));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
