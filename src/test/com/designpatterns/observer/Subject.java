package test.com.designpatterns.observer;

public interface Subject {

	public void removeObserver(Observer o);
	
	public void notifyObservers();

	public void registerObserver(Observer o);
}
