package test.com.baisc;

public class StringAndChar {

	public static void main(String[] args) {
		String ss = new String("afdas");
		String s = "hello world";
		char[] chars = s.toCharArray();
		for(char c : chars){
			System.out.println(c);
		}
	}
}
