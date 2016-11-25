package test.com.designpatterns.observer;

import java.util.ArrayList;

public class WeatherData implements Subject{

	private ArrayList<Observer> observers;
	
	private float temperature;
	
	private float pressure;
	
	private float humidity;
	
	public WeatherData() {
		observers = new ArrayList<Observer>();
	}
	
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i >= 0){
			observers.remove(i);
		}
		
	}

	@Override
	public void notifyObservers() {
		for(int i = 0; i < observers.size() ; i++){
			Observer observer = observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurmentsChanged(){
		notifyObservers();
	}

	public void setMeasurements(float temperature,float pressure,float humidity){
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		measurmentsChanged();
	}
	
}
