package test.com.jsonandxml;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

public class Test {

	public static void main(String[] args) throws DocumentException {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><SiebelMessage><OrderEntry-Orders><code>0000</code><results>成功</results><packageUseCase><businessNum>266</businessNum><responseNum>0  </responseNum><operationType>18097867296     </operationType><packageUseCaseL1>684   </packageUseCaseL1><packageUseCaseInfo><packageName>新飞Young201503 39元畅打卡</packageName><project>本地长市</project><total>180分钟</total><used>486分钟</used><remainder>0分钟</remainder></packageUseCaseInfo><packageUseCaseInfo><packageName>新飞Young201503 39元畅打卡</packageName><project>手机上网流量(省内）</project><total>750MB</total><used>1073.29MB</used><remainder>0MB</remainder></packageUseCaseInfo><packageUseCaseInfo><packageName>新飞Young201503 39元畅打卡</packageName><project>WiFi上网时长</project><total>1080分钟</total><used>0分钟</used><remainder>1080分钟</remainder></packageUseCaseInfo><packageUseCaseInfo><packageName>天翼e家-e9全家福-99元</packageName><project>固话本地畅打</project><total>1000分钟</total><used>0分钟</used><remainder>1000分钟</remainder></packageUseCaseInfo><packageUseCaseInfo><packageName>天翼e家-e9全家福-99元</packageName><project>手机上网流量(国内）</project><total>775.96MB</total><used>3.26MB</used><remainder>772.70MB</remainder></packageUseCaseInfo><packageUseCaseInfo><packageName>天翼e家-e9全家福-99元</packageName><project>天翼宽带国内无线上网时长</project><total>3600分钟</total><used>0分钟</used><remainder>3600分钟</remainder></packageUseCaseInfo><packageUseCaseInfo><packageName>天翼e家-e9全家福-99元</packageName><project>本地长途国内漫游费</project><total>59元</total><used>0.45元</used><remainder>58.55元</remainder></packageUseCaseInfo><packageUseCaseInfo><packageName>WIFI每月赠送10小时</packageName><project>WiFi上网时长</project><total>600分钟</total><used>0分钟</used><remainder>600分钟</remainder></packageUseCaseInfo></packageUseCase></OrderEntry-Orders></SiebelMessage>";
//		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><SiebelMessage><OrderEntry-Orders><code>0000</code><results>成功</results><packageUseCase><businessNum>266</businessNum><responseNum>0  </responseNum><operationType>18097867296     </operationType><packageUseCaseL1>684   </packageUseCaseL1><packageUseCaseInfo><packageName>新飞Young201503 39元畅打卡</packageName><project>本地长市</project><total>180分钟</total><used>486分钟</used><remainder>0分钟</remainder></packageUseCaseInfo></packageUseCase></OrderEntry-Orders></SiebelMessage>";
		XMLSerializer serializer = new XMLSerializer();
		Document document = DocumentHelper.parseText(xml);
		Element element = document.getRootElement().element("OrderEntry-Orders").element("packageUseCase");
		String reslut = element.asXML();
		System.out.println(reslut);
		@SuppressWarnings("unchecked")
		List<Element> list = element.elements("packageUseCaseInfo");
		if(list!=null && list.size()>1){
			JSONArray array = JSONObject.fromObject(serializer.read(reslut)).getJSONArray("packageUseCaseInfo");
			System.out.println(array);
		}else{
			JSONObject jsonObject = JSONObject.fromObject(serializer.read(reslut)).getJSONObject("packageUseCaseInfo");
			System.out.println(jsonObject);
		}
		//System.out.println(array);
	}
}
