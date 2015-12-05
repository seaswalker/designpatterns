package strategy;

/**
 * 不会叫
 * @author skywalker
 *
 */
public class SlienceChirp implements ChirpBehavior {

	@Override
	public void chirp() {
		System.out.println("我特么不会叫");
	}

}
