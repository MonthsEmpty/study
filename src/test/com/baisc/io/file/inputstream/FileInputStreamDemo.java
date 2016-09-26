package test.com.baisc.io.file.inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author vincent
 *
 */
public class FileInputStreamDemo {

	public static void main(String[] args) {
		read4();
	}
	
	/**
	 * 如果byte数组的大小设置过小则内容无法显示齐全，而过大则浪费空间
	 * 下面则针对这个来解决
	 */
	public static void read(){
		File f = new File("G:" + File.separator + "test.txt");
		try {
			InputStream inputStream = new FileInputStream(f);
			byte[] b = new byte[8];
			inputStream.read(b);
			inputStream.close();
			System.out.println("内容为：" + new String(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * File类中存在着length()的方法，可以获取文件大小
	 */
	public static void read2(){
		File f = new File("G:" + File.separator + "test.txt");
		try {
			InputStream inputStream = new FileInputStream(f);
			byte[] b = new byte[(int) f.length()];
			inputStream.read(b);
			inputStream.close();
			System.out.println("内容为：" + new String(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用read()通过循环读取
	 */
	public static void read3(){
		File f = new File("G:" + File.separator + "test.txt");
		try {
			InputStream inputStream = new FileInputStream(f);
			byte[] b = new byte[(int) f.length()];
			for(int i = 0;i<b.length;i++){
				b[i] = (byte) inputStream.read();
			}
			inputStream.close();
			System.out.println("内容为：" + new String(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 未知输入内容多大时，使用判断是否读到文件末尾的方式读取文件
	 */
	public static void read4(){
		//第一步：通过File类找到一个文件
		File f = new File("G:" + File.separator + "test.txt");
		try {
			//第二步：实例化InputStream
			InputStream inputStream = new FileInputStream(f);
			//第三步：进行读操作
			int len = 0;
			byte b[] = new byte[1024];
			int temp = 0;
			while((temp = inputStream.read()) != -1){
				b[len] = (byte) temp;
				len++;
			}
			inputStream.close();
			System.out.println("内容为：" + new String(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
