package test.com.baisc.io.file.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterDemo {

	public static void main(String[] args) {
		writer();
	}
	
	/**
	 * 字节流有缓冲区的概览
	 */
	public static void writer(){
		File f = new File("G:" + File.separator + "test.txt");
		try {
			Writer writer = new FileWriter(f);
			writer.write("helloworld");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
