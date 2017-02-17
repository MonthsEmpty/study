package test.com.baisc.thread.thinkinginjava;

public class PairValuesNotEqualException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PairValuesNotEqualException() {
	
		super("Pair values not equal: " + Pair.class);
//		super("Pair values not equal: " + Pair.this);
	}
	
	public void checkState(){
		
	}
	
}
