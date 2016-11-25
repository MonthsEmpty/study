package test.com.designpatterns.observer;

public class StatisticsDisplay implements Observer,DisplayElement{

	private float temperture;
	private float humidity;
	private Subject weatherData;
	
	public StatisticsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	@Override
	public void display() {

		System.out.println("ssssss");
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		
		display();
	}

}
