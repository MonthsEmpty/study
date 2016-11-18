package test.com.baisc.io.file.inputstream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStreamDemo {

	public static void main(String[] args) {
          
        try {  
        	File f = new File("D:" + File.separator + "test.txt");
        	InputStream bis = new BufferedInputStream(new FileInputStream(f));  
        	byte[] contents = new byte[1024];  
        	int byteRead = 0;  
        	String strFileContents;  
            while((byteRead = bis.read(contents)) != -1){  
                strFileContents = new String(contents,0,byteRead);  
                System.out.println(strFileContents);  
            }  
            bis.close();
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
	}
}
