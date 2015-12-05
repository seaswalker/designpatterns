package observer;

public class CatObserver implements Observer {
	
	public CatObserver(Subject subject) {
		subject.registeryObserver(this);
	}

	@Override
	public void update(String news) {
		System.out.println("ß÷ÁË¸ößäµÄ " + news);
	}

}
