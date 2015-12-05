package jdkobserver;

public class Client {

	public static void main(String[] args) {
		Subject subject = new Subject();
		new DogObserver(subject);
		new CatObserver(subject);
		
		subject.setNews("≤‚ ‘");
		subject.notifyObservers();
	}
	
}
