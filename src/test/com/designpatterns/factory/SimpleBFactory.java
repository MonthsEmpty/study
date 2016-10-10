package test.com.designpatterns.factory;

public class SimpleBFactory extends SimpleFactoryMethod{

	public Simple getInstance(){
		return new SimpleB();
	}
}
