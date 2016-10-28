package test.com.baisc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	/**
	 * -28
228
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		/*System.out.println(Charset.defaultCharset());
		String a = "中文";
		byte[] aa = a.getBytes("utf-8");
		for(byte b : aa){
			System.out.println(b);
			System.out.println((b & 0xFF));//将byte转换成无符16进制整数
			System.out.println("------------------");
		}*/
		/*byte a = (byte) 129;
		System.out.println(a);*/
	//	System.out.println(new String(aa, "gbk"));
		/*long abc = 123123213123213L;
		byte twelve = 0b1100;//这种二进制表示法只适用于jdk1.7及以上。
		int aaa = 1_0000_0000;
		int j = 2;int k = ~j;
		System.out.println(k);
		int a = 10;
		int b = a << 33;
		System.out.println(b);
		int c = 0b1100_0000_0000_0000_0000_0000_0000_0000;
		System.out.println("c = " + c);
		int d = c <<1;
		System.out.println(d);
		byte x = 5;
		byte y = (byte) -x;
		for(String str : args){
			System.out.println(str);
		}*/
		//现在是：2016-10-27 14:34:06,两小时前是：2016-10-27 12:34:06
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String time1 = "2016-10-27 12:34:06";
		String time2 = "2016-10-27 14:34:06";
		 try {
			long startT=df.parse(time1).getTime();
			long endT=df.parse(time2).getTime();
			long minus = (endT-startT)/1000;
			System.out.println(minus);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
	}

	public static void tset() throws IOException {
		File f = new File("D:" + File.separator + "test/test.txt");
		InputStream inputStream = new FileInputStream(f);
		byte[] b = new byte[1024];
		int temp = 0;
		int i = 0;
		while ((temp = inputStream.read()) != -1) {
			// b[i] = (byte) inputStream.read();
			// //这种错误原因是又读了一次，所以b[i]接受到的其实是一个间隔一个的。
			b[i] = (byte) temp;
			i++;
		}
		System.out.println(new String(b));
	}
}
