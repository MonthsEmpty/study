package test.com.baisc.other;

/**
 * 关于for循环的一些测试
 * @author Administrator
 *
 */
public class ForTest {

	static int[] array = {1,2,3,4,5};
	
	public static void main(String[] args) {
		for(int i = 0;i<array.length;i++){
			System.out.println(array[i]);
		}
		System.out.println("-------------");
		for(int i :array){
			
			System.out.println(i);
		}
	}
}
