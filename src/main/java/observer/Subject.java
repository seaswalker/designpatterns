package observer;

/**
 * ����ӿ�
 * @author skywalker
 *
 */
public interface Subject {

	public void registeryObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObservers();
	
}
