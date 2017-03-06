package test.com.baisc.io.thinkinginjava;

import java.io.IOException;
import java.io.StringReader;

/**
 * 从内存读入
 * @author Administrator
 *
 */
public class MemoryInput {

	public static void main(String[] args) throws IOException {
		StringReader in = new StringReader(BufferedInputFile.read("MemoryInput.java"));
		int c;
		while((c = in.read()) != -1){
			System.out.println((char)c);
		}
	}
}
