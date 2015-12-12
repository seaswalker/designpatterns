package guardedsuspension;

import java.util.concurrent.Callable;

/**
 * 抽象了目标动作，并关联了目标动作所需的保护条件
 * @author skywalker
 *
 */
public abstract class GuardedAction<V> implements Callable<V> {

	protected final Predicacate predicacate;

	public GuardedAction(Predicacate predicacate) {
		this.predicacate = predicacate;
	}
	
}
