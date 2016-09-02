package test.com.baisc.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

public class PropertiesTest {

	private static Properties properties;
	private static InputStream is = null;
	private static Reader reader = null;
	
	/**
	 * 绝对路径的方式
	 */
	public void absolutePath(){
		try {
			properties = new Properties();
			InputStream is = new FileInputStream("D:/workspace/test/src/test/com/servlet/aaa.properties");
			properties.load(is);
		}  catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 相对路径的方式
	 * 相对路径的方式有两种情况
	 * 路径开始以"/"则是相对项目根路径"/aaa.properties"
	 * 路径开始不以"/"则相对类所在的文件路径"aaa.properties"
	 */
	public void relativePath(){
		try {
			properties = new Properties();
		//	is = PropertiesTest.class.getResourceAsStream("/test/com/servlet/aaa.properties");
			is = PropertiesTest.class.getResourceAsStream("bbb.properties");
			properties.load(is);
		}  catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 中文乱码问题
	 * 当然前提是文件保存时就是以utf-8的编码格式保存的
	 */
	public void chineseImproperCode(){
		try {
			properties = new Properties();
			is = PropertiesTest.class.getResourceAsStream("/aaa.properties");
			reader =  new InputStreamReader(is, "UTF-8");
			properties.load(reader);
		}  catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		PropertiesTest pt = new PropertiesTest();
		//pt.absolutePath();
		pt.relativePath();
		//pt.chineseImproperCode();
		System.out.println("姓名=" + properties.getProperty("name"));  
		System.out.println("年龄=" + properties.getProperty("age"));  
	}
}
