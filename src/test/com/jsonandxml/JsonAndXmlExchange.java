package test.com.jsonandxml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

public class JsonAndXmlExchange {

	public static void main(String[] args) {
		xml2Json();
		/*System.out.println("---------------------------------------------------------------");
		String xml = "<body><a>111</a><a>222</a></body>";
		xml2JONObjectOrJSONArray(xml);*/
	}
	
	/**
	 * *xml转成json有个陷阱
	 * <body>
	 *	 	<a></a>
	 * </body>
	 * 这个转后需要再获取a的JSONObejct对象
	 * <body>
	 * 		<a></a>
	 * 		<a></a>
	 * <body/>
	 * 这个获取的就是一个JSONArray
	 */
	public static void xml2Json(){
		String xml1 = "<body><a>111</a></body>";
		String xml2 = "<body><b><a>111</a><a>222</a></b><c><d>123</d></c></body>";
		XMLSerializer serializer = new XMLSerializer();
		JSONObject jsonObject = JSONObject.fromObject(serializer.read(xml2));//xml1:{"a":"111"}。xml2:["111","222"]
		JSON json = (JSON) jsonObject.get("b");
		JSON json1 = (JSON) jsonObject.get("c");
		System.out.println(jsonObject.isArray());
		System.out.println(jsonObject);
		System.out.println(json.isArray());
		System.out.println(json);
		System.out.println(json1.isArray());
		System.out.println(json1);
		
		/*JSONObject jsonObject = JSONObject.fromObject(serializer.read(xml1));
		JSONArray array = JSONArray.fromObject(serializer.read(xml2));
		System.out.println(jsonObject);
		System.out.println(array);*/
	}
	
	/**
	 * @throws DocumentException 
	 * 
	 */
	public static void xml2JONObjectOrJSONArray(String xml){
		Document document;
		try {
			document = DocumentHelper.parseText(xml);
			Element element = document.getRootElement();
			String text = element.asXML();
			String text1 = element.elementText("a");
			System.out.println(text + "------" + text1);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	public static void parseXml(){
		
	}
}
