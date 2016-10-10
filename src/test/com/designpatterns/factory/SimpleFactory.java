package test.com.designpatterns.factory;

public class SimpleFactory {

	public Simple getInstance(String str){
		if("SimpleA".equals(str)){
			return new SimpleA();
		}else if("SimpleB".equals(str)){
			return new SimpleB();
		}else{
			return null;
		}
	}
}
