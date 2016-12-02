package test.com.designpatterns.template;

import java.util.Arrays;

public class DuckSortTest {

	public static void main(String[] args) {
		Duck[] ducks = {
				new Duck("Daffy", 8),
				new Duck("Dawey", 2),
				new Duck("Howard", 7),
				new Duck("Louie", 2),
				new Duck("Donald", 10),
				new Duck("Huey", 2)
		};
		System.out.println("before sorting:");
		display(ducks);
		
		Arrays.sort(ducks);
		System.out.println("After sorting:");
		display(ducks);
	}
	
	public static void display(Duck[] ducks){
		for(Duck duck : ducks){
			System.out.println(duck);
		}
	}
}
