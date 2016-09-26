package test.com.baisc.io.file;

import java.io.File;
import java.io.IOException;

/**
 * 在整个java.io包中，唯一与文件本身有关的类就是File类。
 * 实例化一个File类就可以做相关操作了，而实例化File类的关键就是给定路径！
 * File类只是针对文件本身进行操作，如果对文件内容进行操作则可以使用RanDomAccessFile类
 * @author Administrator
 *
 */
public class FileDemo {

	public static void main(String[] args) {
		//	createFile();
		//deleteFile();
		makeDir();
	}
	
	/**
	 * 新建一个文件
	 * 使用File.separator可以跨平台
	 */
	public static void createFile(){

		//File f = new File("G:\\text.txt");
		//使用File.separator可以跨平台
		File f = new File("G:" + File.separator + "text.txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 删除一个文件
	 * 这里有个疑问为何创建用了异常处理而删除为何没有？
	 */
	public static void deleteFile(){
		File f = new File("G:" + File.separator + "text.txt");
		if(f.exists()){
			f.delete();
			System.out.println("文件删除成功");
		}else{
			System.out.println("文件不存在");
		}
	}
	
	/**
	 * 创建文件夹
	 */
	public static void makeDir(){
		File f = new File("G:" + File.separator + "vincent");
		f.mkdir();
	}
	
	
}
