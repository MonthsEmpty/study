package test.com.baisc.io.file.outputsream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		DataOutputStream out = new DataOutputStream(new FileOutputStream(new File("D:" + File.separator + "test.txt")));
		out.writeByte(1);
		out.writeChars("afadsf");
		out.write("hello world".getBytes());
		out.close();
	}
}
