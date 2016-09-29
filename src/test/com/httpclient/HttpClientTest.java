package test.com.httpclient;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
/**
 * 
 * @author Administrator
 *
 */

public class HttpClientTest {

	public static void main(String[] args) {
		HttpClientTest.specialPost1();
	//	PostMethod method = new PostMethod(""); 
		
	}
	
	public static void get(){
		/**
		 * org.apache.commons.httpclient.HttpClient还是class
		 * org.apache.http.client.HttpClient已经是interface了
		 */
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// 创建httpget.    
			HttpGet httpget = new HttpGet("http://localhost:8080/test/MyTestServlet?paramter=111");
			System.out.println("executing request " + httpget.getURI());
			// 执行get请求.    
			//要是不加httpcore-4.4.4.jar这边编译不过去，有空看看
			CloseableHttpResponse response = httpclient.execute(httpget);
			// 获取响应实体    
            HttpEntity entity = response.getEntity();
            System.out.println("--------------------------------------");  
            // 打印响应状态    
            System.out.println(response.getStatusLine());
            if (entity != null) {  
                // 打印响应内容长度    
                System.out.println("Response content length: " + entity.getContentLength());  
                // 打印响应内容    
                System.out.println("Response content: " + EntityUtils.toString(entity));  
            }  
            System.out.println("------------------------------------"); 
            
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}  
		}
	}
	
	/**
	 * 普通的post请求
	 */
	public static void commonPost(){
		// 创建默认的httpClient实例. 
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建httppost    
        HttpPost httppost = new HttpPost("http://localhost:8080/test/MyTestServlet");
        // 创建参数队列    
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
        formparams.add(new BasicNameValuePair("paramter", "hou12312se"));
        UrlEncodedFormEntity uefEntity;  
        try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(uefEntity);  
			System.out.println("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpClient.execute(httppost);
            HttpEntity entity = response.getEntity();  
            if (entity != null) {  
                System.out.println("--------------------------------------");  
                System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));  
                System.out.println("--------------------------------------");  
            } 
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}  
		}
		
	}
	
	/**
	 * 请求参数以名值对形式传递
	 */
	public static void specialPost(){
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("");
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("UserNumber", "13173001830"));
		list.add(new BasicNameValuePair("corp_id", "qd007"));
		httpPost.setHeader("Content-Type", "application/json");
		try {
			UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list);
			httpPost.setEntity(urlEncodedFormEntity);
			CloseableHttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity(); 
			System.out.println(EntityUtils.toString(entity, "utf-8"));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * post请求，请求参数是一个文本而不是名值对
	 */
	public static void specialPost1(){
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://localhost:8081/test/doPostTestServlet");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "vincent");
		jsonObject.put("age", "24");//换成int型的有区别吗？
		jsonObject.put("height", "182");
		System.out.println("jsonObject大小:" + jsonObject.size());
		httpPost.setHeader("Content-Type", "application/json");
		StringEntity entity = new StringEntity(jsonObject.toString(), "utf-8");
		httpPost.setEntity(entity);
		try {
			CloseableHttpResponse response = httpClient.execute(httpPost);
			HttpEntity httpEntity = response.getEntity();
			System.out.println(EntityUtils.toString(httpEntity, "utf-8"));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** 
     * 上传文件 
     */  
    public void upload() {  
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        try {  
            HttpPost httppost = new HttpPost("http://localhost:8080/myDemo/Ajax/serivceFile.action");  
  
            FileBody bin = new FileBody(new File("F:\\image\\sendpix0.jpg"));  
            StringBody comment = new StringBody("A binary file of some kind", ContentType.TEXT_PLAIN);  
  
            HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("bin", bin).addPart("comment", comment).build();  
  
            httppost.setEntity(reqEntity);  
  
            System.out.println("executing request " + httppost.getRequestLine());  
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
                System.out.println("----------------------------------------");  
                System.out.println(response.getStatusLine());  
                HttpEntity resEntity = response.getEntity();  
                if (resEntity != null) {  
                    System.out.println("Response content length: " + resEntity.getContentLength());  
                }  
                EntityUtils.consume(resEntity);  
            } finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    } 
}
