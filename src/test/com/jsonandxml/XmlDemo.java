package test.com.jsonandxml;

import java.io.InputStream;
import java.io.Reader;
import java.util.Iterator;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlDemo {

	private static InputStream is = null;
	private static Reader reader = null;
	
	public static void main(String[] args) {
		getXml();
	}
	
	public static void getXml(){
		try {
			is = XmlDemo.class.getResourceAsStream("/xmldemo.xml");
			SAXReader reader = new SAXReader(); 
			Document document = reader.read(is);
			Element element = document.getRootElement();
			Element foo;   
			for (Iterator i = element.elementIterator("VALUE"); i.hasNext();) {   
			    foo = (Element) i.next();   
			    System.out.print("车牌号码:" + foo.elementText("NO"));   
			    System.out.println("车主地址:" + foo.elementText("ADDR"));   
			   }  
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
