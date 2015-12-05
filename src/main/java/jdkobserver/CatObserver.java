package jdkobserver;

import java.util.Observable;
import java.util.Observer;

public class CatObserver implements Observer {
	
	public CatObserver(Observable observable) {
		observable.addObserver(this);
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
		System.out.println("ß÷ÁË¸ößäµÄ : " + news);
	}

}
