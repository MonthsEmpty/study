package test.com.baisc.collections;

public class Groundhog2 extends Groundhog{

	public Groundhog2(int n) {
		super(n);
	}
	
	@Override
	public int hashCode() {
		return number;
	}
	
	@Override
	public boolean equals(Object obj) {
		// 看起来instanceof只是检查了obj是否是Groundhog2的实例，但instanceof悄悄的检查了此对象是否为null
		return obj instanceof Groundhog2 && (number == ((Groundhog2)obj).number);
	}

	
}
