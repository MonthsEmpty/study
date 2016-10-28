package test.com.baisc.enumtest;

public class Test {

	public static void main(String[] args) {
		/*for(EnumTest e : EnumTest.values()){
			System.out.println(e.toString());
		}
		
		System.out.println("----------------我是分隔线------------------");
		
		EnumTest test = EnumTest.TUE;
		switch (test) {
        case MON:
            System.out.println("今天是星期一");
            break;
        case TUE:
            System.out.println("今天是星期二");
            break;
        // ... ...
        default:
            System.out.println(test);
            break;
        }*/
		
		/* System.out.println("EnumTest.FRI 的 value = " + EnumTest.FRI.getValue());
		 System.out.println("EnumTest.FRI 的 Rest = " + EnumTest.FRI.isRest());
		 System.out.println("EnumTest.SAT 的 Rest = " + EnumTest.SAT.isRest());*/
		 /*Class clz = Color.class;
		  for (Object obj : clz.getEnumConstants()) {
			  System.out.println(obj.toString());
		  }*/
		People people = People.OLD;
		System.out.println(people.getProfession());
		Phone phone = Phone.HTC;
		System.out.println(phone);
		for(Phone pp : Phone.values()){
			System.out.println(pp);
		}
	}
	
	public enum Phone{
		IPHONE,HTC
	}
}
