package test.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.builder.BuilderException;
import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.apache.ibatis.parsing.PropertyParser;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


public class Test {
	
	private static DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");

	public static void main(String[] args) {
/*DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Calendar calendar = Calendar.getInstance();
		Date d = calendar.getTime();
		System.out.println(df.format(d));

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://localhost:8080/sms-interface-monitor/email.xhtml?db=vincent");
		String param = "vincenttest1,testnum=12 num="+ new Random().nextInt(10);
		httpPost.setHeader("Content-Type", "text/html");
		StringEntity entity = new StringEntity(param, "utf-8");
		httpPost.setEntity(entity);
		try {
			CloseableHttpResponse response = httpClient.execute(httpPost);
			StatusLine sl = response.getStatusLine();
			System.out.println(sl.getStatusCode());
			HttpEntity httpEntity = response.getEntity();
			// 这边居然没有返回东西，但测试已经提交过去了，暂时不清楚为何没返回
			System.out.println(EntityUtils.toString(httpEntity, "utf-8"));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		/*JSONObject jsonObject = new JSONObject();
		JSONObject userFlag = new JSONObject();
		userFlag.put("subscrbType", "0");
		userFlag.put("flag3g", "3");
		jsonObject.put("extraData", userFlag.toString());
		JSONObject resultObject = new JSONObject();
		resultObject.put("result", jsonObject);
		System.out.println(resultObject);
		
		String extraData = JSONObject.fromObject(resultObject.get("result")).getString("extraData");
		System.out.println(extraData);
		JSONObject date = JSONObject.fromObject(extraData);
		System.out.println(date);
		System.out.println(date.getString("subscrbType"));*/
		/*DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		System.out.println(df.format(calendar.getTime()));
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)-5);
		String yesterday = df.format(calendar.getTime());
		System.out.println(yesterday);*/
		int i = -1;
		System.out.println( 2 + i);
		
		//String extraData = JSONObject.fromObject(jsonObject2.getJSONObject("result")).getString("extraData");
		//System.out.println(extraData);
		
		
		/*String extraData = "{\"subscrbType\":\"0\",\"flag3g\":\"3\"}";
		JSONObject json = JSONObject.fromObject(extraData);
		
		String extraData = JSONObject.fromObject(json.get("result")).getString("extraData");
		JSONObject date = JSONObject.fromObject(extraData);*/

	}

	
	
	private Properties parseAttributes(Node n) {
		Properties attributes = new Properties();
		NamedNodeMap attributeNodes = n.getAttributes();
		if (attributeNodes != null) {
			for (int i = 0; i < attributeNodes.getLength(); ++i) {
				Node attribute = attributeNodes.item(i);
				String value = PropertyParser.parse(attribute.getNodeValue(), null);
				attributes.put(attribute.getNodeName(), value);
			}
		}
		return attributes;
	}
	
	private Document createDocument(InputSource inputSource) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setValidating(true);

			factory.setNamespaceAware(false);
			factory.setIgnoringComments(true);
			factory.setIgnoringElementContentWhitespace(false);
			factory.setCoalescing(false);
			factory.setExpandEntityReferences(true);

			DocumentBuilder builder = factory.newDocumentBuilder();
			builder.setEntityResolver(new XMLMapperEntityResolver());
			builder.setErrorHandler(new ErrorHandler() {
				public void error(SAXParseException exception) throws SAXException {
					throw exception;
				}

				public void fatalError(SAXParseException exception) throws SAXException {
					throw exception;
				}

				public void warning(SAXParseException exception) throws SAXException {
				}
			});
			return builder.parse(inputSource);
		} catch (Exception e) {
			throw new BuilderException("Error creating document instance.  Cause: " + e, e);
		}
	}

}
