package test.com.designpatterns.observer.javastyle;

import java.util.Observable;

public class WeatherData extends Observable {

	private float temperature;

	private float pressure;

	private float humidity;
	
	public void measurementsChanged(){
		setChanged();
		notifyObservers();
	}
	
	public void setMeasurements(float temperature,float pressure,float humidity){
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		measurementsChanged();
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	
	
}
