package test.com.designpatterns.observer.javastyle;

import java.util.Observable;
import java.util.Observer;

import test.com.designpatterns.observer.DisplayElement;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	Observable observable;
	private float temperature;
	private float humidity;

	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature + "F degress and " + humidity + "% humidity");

	}

	@Override
	public void update(Observable obs, Object paramObject) {

		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) obs;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}
}