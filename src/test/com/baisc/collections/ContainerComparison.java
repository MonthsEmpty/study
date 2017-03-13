package test.com.baisc.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContainerComparison {

	public static void main(String[] args) {
		BerylliumSpere[] spheres = new BerylliumSpere[10];
		for(int i = 0;i<5;i++){
			spheres[i] = new BerylliumSpere();
		}
		System.out.print(Arrays.toString(spheres));
		System.out.println(spheres[4]);
		List<BerylliumSpere> sphereList = new ArrayList<BerylliumSpere>();
		for(int i =0;i<5;i++){
			sphereList.add(new BerylliumSpere());
		}
		System.out.print(sphereList);
		System.out.println(sphereList.get(4));
		
		int[] intgers = {0,1,2,3,4,5};
		System.out.print(Arrays.toString(intgers));
		System.out.println(intgers[4]);
		
		List<Integer> intList = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5));
		intList.add(97);
		System.out.print(intList);
		System.out.println(intList.get(4));
		
	}
}

class BerylliumSpere{
	private static long counter;
	private final long id = counter++;
	@Override
	public String toString() {
		return "Sphere " + id;
	}
}
