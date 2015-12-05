package observer;

/**
 * ≤‚ ‘
 * @author skywalker
 *
 */
public class Client {
	
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		new DogObserver(weatherData);
		new CatObserver(weatherData);
		weatherData.setNews("fuck");
	}

}
