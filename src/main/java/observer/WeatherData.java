package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 气象数据
 * @author skywalker
 *
 */
public class WeatherData implements Subject {
	
	private List<Observer> observers = new ArrayList<Observer>();
	//更新的数据
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
	 * 模拟更新
	 */
	public void setNews(String news) {
		this.news = news;
		notifyObservers();
	}

}
