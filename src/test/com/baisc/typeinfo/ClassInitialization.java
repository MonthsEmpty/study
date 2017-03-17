//: typeinfo/ClassInitialization.java
package test.com.baisc.typeinfo;

import java.util.*;

class Initable {
	static final int staticFinal = 47;
	static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
	static {
		System.out.println("Initializing Initable");
	}
}

class Initable2 {
	static int staticNonFinal = 147;
	static {
		System.out.println("Initializing Initable2");
	}
}

class Initable3 {
	static int staticNonFinal = 74;
	static {
		System.out.println("Initializing Initable3");
	}
}

/**
 * 触发类初始化的几种情况
 * 1、调用static的值
 * 2、调用static final 的非固定值
 * 3、采用Class.forName()创建类型引用的方式
 * @author Administrator
 *
 */
public class ClassInitialization {
	public static Random rand = new Random(47);

	public static void main(String[] args) throws Exception {
		Class initable = Initable.class;
		System.out.println("After creating Initable ref");
		// Does not trigger initialization:
		System.out.println(Initable.staticFinal);//static final 的固定值
		// Does trigger initialization:
		System.out.println(Initable.staticFinal2);//static final 的非固定值
		// Does trigger initialization:
		System.out.println(Initable2.staticNonFinal);// static int
		Class initable3 = Class.forName("test.com.baisc.typeinfo.Initable3");
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticNonFinal);
	}
} /*
 * Output: After creating Initable ref 47 Initializing Initable 258 Initializing
 * Initable2 147 Initializing Initable3 After creating Initable3 ref 74
 */// :~
