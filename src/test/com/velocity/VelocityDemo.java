package test.com.velocity;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class VelocityDemo {

	public static void main(String[] args) {
		try {
			// 初始化参数
			Properties properties = new Properties();
			// 设置velocity资源加载方式为class
			properties.setProperty("resource.loader", "class");
			// 设置velocity资源加载方式为file时的处理类
			properties.setProperty("class.resource.loader.class",
					"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
			Velocity.init(properties);
			
			//---------------------------------华丽的分隔线--------------------------------------------
			//以上是Velocity的初始化工作，从类路径寻找文件。
			Template template = Velocity.getTemplate("hellovelocity.vm");
			VelocityContext context = new VelocityContext();
			context.put("name", "vincent");
			context.put("date", new Date());
			StringWriter writer = new StringWriter();
			template.merge(context, writer);
			writer.close();
			System.out.println(writer.toString());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
