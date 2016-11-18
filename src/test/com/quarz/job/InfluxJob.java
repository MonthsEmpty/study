package test.com.quarz.job;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class InfluxJob implements Job {

	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Calendar calendar = Calendar.getInstance();
		Date d = calendar.getTime();
		System.out.println(df.format(d));

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://10.99.8.172:8086/write?db=vincent");
		String param = "batchtest,testnum=12 num="+ new Random().nextInt(10);
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
		}
	}

}
