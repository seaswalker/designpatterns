package observer;

public class DogObserver implements Observer {

	public DogObserver(Subject subject) {
		subject.registeryObserver(this);
	}

	@Override
	public void update(String news) {
		System.out.println("ÍôÍô£¬" + news);
	}
	
}
