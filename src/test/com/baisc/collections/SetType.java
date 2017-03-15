package test.com.baisc.collections;

public class SetType {

	int i;
	public SetType(int n) {
		i = n;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof SetType && (i == ((SetType)obj).i);
	}
	
	@Override
	public String toString() {
		return Integer.toString(i);
	}
}
