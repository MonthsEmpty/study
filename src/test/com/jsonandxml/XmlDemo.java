package test.com.jsonandxml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlDemo {

	private static InputStream is = null;
	
	public static void main(String[] args) {
		//getXmlFromXmlFile();
		getXmlFromXmlString();
	}
	
	/**
	 * 从xml文件中读取
	 */
	@SuppressWarnings("rawtypes")
	public static void getXmlFromXmlFile(){
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
	
	/**
	 * 操作xml
	 */
	public static void getXmlFromXmlString(){
		try {
			String xml = "<body><a>111</a><a>222</a><b name=\"vincent\" age=\"24\" height=\"182\">333</b></body>";
			//将xml格式的字符串转为Document,与之相反的操作则是
			Document document = DocumentHelper.parseText(xml);
			
			//将document转为字符串
			String documentText = document.asXML();
			System.out.println(documentText);
			System.out.println("-----------华丽的分割线--------------");
			//获取文档的根节点,此处就是body节点
			Element rootElement = document.getRootElement();
			
			//取得节点下的子节点，如果有多个则取得是第一个，也就是最前面的那个
			Element sonElement = rootElement.element("a");
			
			//获取节点下的内容,此处就是第一个节点a的内容也就是111
			String text = sonElement.getText();
			System.out.println("第一个节点a的内容的内容：" + text);
			
			//将节点的xml转为字符串，包括节点的所有xml信息，此处则是<a>111</a>
			String somXml = sonElement.asXML();
			System.out.println("节点a的xml：" + somXml);
			
			//获取节点下所有节点名为"a"的节点
			List<Element> list = rootElement.elements("a");
			for(Element element : list){
				System.out.println(element.getText());
			}
			System.out.println("-----------华丽的分割线--------------");
			
			//对某节点下的所有子节点进行遍历
			for(Iterator it = rootElement.elementIterator();it.hasNext();){
				Element element = (Element) it.next();
				String elemetName = element.getName();
				String elementText = element.getText();
				System.out.println(elemetName + "标签的内容是:" + elementText);
			}
			System.out.println("-----------华丽的分割线--------------");
			
			/**
			 * 获取节点下的属性
			 * 什么是属性呢？以<b name="vincent">333</b>为例，name就是b节点的属性，vincent就是该属性的属性值
			 */
			Element elementB = rootElement.element("b");
			Attribute nameAttribute = elementB.attribute("name");
			
			//获取属性值,两种方式;此处的值就是vincent
			String attributeBText = nameAttribute.getText();
			String attributeBText2 = elementB.attributeValue("name");
			System.out.println(attributeBText + "=====" + attributeBText2);
			System.out.println("-----------华丽的分割线--------------");
			
			//遍历某个节点下的所有属性
			for(Iterator it=elementB.attributeIterator();it.hasNext();){
				Attribute attribute = (Attribute) it.next();
				String attributeName = attribute.getName();
                String attributeText = attribute.getText();
                System.out.println(attributeName + ":" + attributeText);
			}
			System.out.println("---------------大大的分割线，以上都是读的操作，下面就是改与写了----------------------");
			
			//节点b新增属性weight，值为65
			elementB.addAttribute("weight", "65公斤");
			
			//删除节点b的name属性
			if(nameAttribute != null){
				elementB.remove(nameAttribute);
			}
			
			//无编码格式需求将上面的xml输出
			XMLWriter xmlWriter = new XMLWriter(new FileWriter("output.xml"));
			xmlWriter.write(document);
			xmlWriter.close();
			
			//按指定编码格式将xml输出
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("gbk");
			XMLWriter writer = new XMLWriter(new FileWriter("output1.xml"),format);
			writer.write(document);
			writer.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
