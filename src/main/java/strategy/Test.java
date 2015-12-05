package strategy;

public class Test {

	public static void main(String[] args) {
		RubberDuck rubberDuck = new RubberDuck(new FlyWithRocket(), new SlienceChirp());
		rubberDuck.performFly();
		rubberDuck.performChirp();
	}
	
}
