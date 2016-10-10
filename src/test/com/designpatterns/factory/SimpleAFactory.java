package test.com.designpatterns.factory;

public class SimpleAFactory extends SimpleFactoryMethod{

	public Simple getInstance(){
		return new SimpleA();
	}
}
