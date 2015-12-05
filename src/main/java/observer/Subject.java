package observer;

/**
 * 主题接口
 * @author skywalker
 *
 */
public interface Subject {

	public void registeryObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObservers();
	
}
