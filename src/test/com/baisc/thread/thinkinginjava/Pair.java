package test.com.baisc.thread.thinkinginjava;

public class Pair {

	private int x,y;
	public Pair(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public Pair() {
		this(0, 0);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	@Override
	public String toString() {
		return "x: " + x + ",y: " + y;
	}
	
}
