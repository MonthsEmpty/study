package test.com.baisc;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class Test {

	public static void main(String[] args) {
		LoggingInfo logInfo = new LoggingInfo("MIKE", "MECHANICS");  
		try  
		{   
		   ObjectOutputStream o = new ObjectOutputStream(   
		                new FileOutputStream("logInfo.out"));   
		   o.writeObject(logInfo);   
		   o.close();   
		}   
		catch(Exception e) {}   
		  
		  
		try  
		{   
		   ObjectInputStream in =new ObjectInputStream(   
		                new FileInputStream("logInfo.out"));   
		   LoggingInfo logInfo1 = (LoggingInfo)in.readObject();   
		   System.out.println(logInfo.toString());   
		}   
		catch(Exception e1) {}   
	}
}
