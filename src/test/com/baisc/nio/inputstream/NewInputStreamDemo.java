package test.com.baisc.nio.inputstream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NewInputStreamDemo {

	public static void main(String[] args) {
		Path path = Paths.get("");
		try {
			InputStream inputStream = Files.newInputStream(path,StandardOpenOption.READ);
			BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
