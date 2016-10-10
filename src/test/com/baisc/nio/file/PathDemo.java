package test.com.baisc.nio.file;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * @author Administrator
 *
 */
public class PathDemo {

	public static void main(String[] args) throws IOException {
		//FileSystem表示一个文件系统，可以调用FileSystems.getDefault()来获取当前的文件系统
		FileSystem fileSystem = FileSystems.getDefault();
		//通过FileSystem的getSeparator()方法获取分隔符，之前的java.io中使用的是File.separator
		String separator = fileSystem.getSeparator();
		System.out.println(separator);
		//使用FileSystem的getPath方法创建一个Path
		String str = "D:" + separator + "test/test.txt";
		System.out.println(str);
		Path path = fileSystem.getPath(str);
//		Path path = fileSystem.getPath("D:/test/test.txt");
		//通过Paths的get方法获取path
		System.out.println(path.getNameCount());
		System.out.println(path.getName(0));
		System.out.println(path.getName(1));
		System.out.println(path.getFileName());
		Path path1 = Paths.get("D:/test/test1.txt");
		//如果父目录不存在则报java.nio.file.NoSuchFileException: D:\test\test\test1.txt
		//如果文件已经存在则报java.nio.file.FileAlreadyExistsException: D:\test\test1.txt
		Files.createFile(path1);
		//如果父目录不存在则报java.nio.file.NoSuchFileException: D:\test\test\test
		//如果已经存在则报java.nio.file.FileAlreadyExistsException: D:\test
		Files.createDirectory(Paths.get("D:/test/test"));
	}
}
