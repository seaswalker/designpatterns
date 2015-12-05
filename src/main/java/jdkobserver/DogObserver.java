package jdkobserver;

import java.util.Observable;
import java.util.Observer;

public class DogObserver implements Observer {
	
	public DogObserver(Subject subject) {
		subject.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Subject) {
			Subject subject = (Subject) o;
			String news = subject.getNews();
			display(news);
		}
	}
	
	public void display(String news) {
		System.out.println("ÍôÍô : " + news);
	}

}
