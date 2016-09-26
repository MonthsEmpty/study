package test.com.baisc.io.file.outputsream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * @author vincent
 *
 */
public class FileOutputSreamDemo {

	public static void main(String[] args) {
		//write();
		append();
	}

	/**
	 * 向文件中写东西,采用讲字符串变为byte数组，然后将byte数组直接写入到文件中的方式 文件不存在则会自动创建
	 */
	@SuppressWarnings("resource")
	public static void write() {
		File f = new File("G:" + File.separator + "test.txt");
		try {
			OutputStream out = new FileOutputStream(f);
			String str = "Hello World";
			byte[] b = str.getBytes();
			out.write(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 采用讲字符串变为byte数组，然后将byte数组，然后通过循环一个一个地写入到文件中的方式
	 */
	public static void writeInt() {
		File f = new File("G:" + File.separator + "test.txt");
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(f);
			String str = "Hello World";
			byte[] b = str.getBytes();
			for (byte b1 : b) {
				outputStream.write(b1);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 上面的方法如果重新运行则会将之前的文件内容覆盖，FileOutputStream的另外一个构造方法可以实现内容的追加
	 */
	public static void append(){
		File f = new File("G:" + File.separator + "test.txt");
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(f, true);
			String str = "Hello World";
			byte[] b = str.getBytes();
			for (byte b1 : b) {
				outputStream.write(b1);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
