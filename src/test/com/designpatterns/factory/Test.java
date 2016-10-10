package test.com.designpatterns.factory;

public class Test {

	public static void main(String[] args) {
		SimpleFactory factory = new SimpleFactory();
		Simple simple = factory.getInstance("SimpleA");
		simple.print();
		SimpleFactoryMethod factoryMethod = new SimpleAFactory();
		Simple simple2 = factoryMethod.getInstance();
		simple2.print();
	}
}
