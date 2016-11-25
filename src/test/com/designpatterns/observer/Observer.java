package test.com.designpatterns.observer;

public interface Observer {

	//直接将观测值传给了观察者，这样合适吗？
	//如果将来多加一个参数，岂不是需要改变很多方法了，用map更合适吧
	public void update(float temp, float humidity, float pressure);
}
