package guardedsuspension;

import java.util.concurrent.Callable;

/**
 * 负责执行guardedMethod方法的线程进行挂起和唤醒，并执行ConcreteGuardAction所实现的目标操作
 * @author skywalker
 *
 */
public interface Blocker {

	/**
	 * 在保护条件成立时立即执行目标动作，否则阻塞当前线程，直到保护条件成立
	 * @param guardedAction 带保护条件的目标动作
	 * @return
	 * @throws Exception
	 */
	<V> V callWithGuard(GuardedAction<V> guardedAction) throws Exception;
	
	/**
	 * 执行stateOperation决定是否唤醒本Blocker所暂挂的线程中的一个
	 * @param stateOperation  更改状态的操作，如果返回true，那么执行唤醒操作
	 * @throws Exception
	 */
	void signalAfter(Callable<Boolean> stateOperation) throws Exception;
	
	void signal() throws InterruptedException;
	
	/**
	 * 和signalAfter不同的就是这个在底层执行siganlAll
	 * @param stateOperation
	 * @throws Exception
	 */
	void broadcastAfter(Callable<Boolean> stateOperation) throws Exception;
	
}
