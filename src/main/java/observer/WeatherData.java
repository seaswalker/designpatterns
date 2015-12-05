package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������
 * @author skywalker
 *
 */
public class WeatherData implements Subject {
	
	private List<Observer> observers = new ArrayList<Observer>();
	//���µ�����
	String news = null;

	@Override
	public void registeryObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer observer : observers) {
			observer.update(news);
		}
	}
	
	/**
	 * ģ�����
	 */
	public void setNews(String news) {
		this.news = news;
		notifyObservers();
	}

}
