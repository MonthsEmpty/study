package test.com.designpatterns.observer;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData data = new WeatherData();
		CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(data);
		StatisticsDisplay display = new StatisticsDisplay(data);
		data.setMeasurements(80, 65, 30.4f);
	}
}
