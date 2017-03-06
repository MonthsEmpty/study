package test.com.baisc.io.thinkinginjava;

import java.io.File;
import java.io.IOException;

public class Test {

	public void ShowUrl() throws IOException{
		/**
		 * 下面这两种其实没啥区别的
		 * this.getClass().getResource()的实现就是用的ClassLoader的getResource
		 * paramString = resolveName(paramString);
			ClassLoader localClassLoader = getClassLoader0();
			if (localClassLoader == null)
				return ClassLoader.getSystemResource(paramString);
			return localClassLoader.getResource(paramString);
		 * 
		 */
		System.out.println(this.getClass().getResource("/"));
		System.out.println(this.getClass().getClassLoader().getResource(""));
		File file = new File("");
		System.out.println(file.getCanonicalPath());
		System.out.println(file.getAbsolutePath());
	}
	
	public static void main(String[] args) throws IOException {
		Test test = new Test();
		test.ShowUrl();
	}
}
//file:/C:/Users/Administrator/git/study/build/classes/