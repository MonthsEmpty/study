package test.com.baisc.collections;

public class Groundhog {

	protected int number;
	
	public Groundhog(int n) {
		this.number = n;
	}
	
	@Override
	public String toString() {
		return "Groundhog #" + number;
	}
}
