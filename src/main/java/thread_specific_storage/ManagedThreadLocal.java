package thread_specific_storage;

import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 支持统一清理不再被使用的ThreadLocal变量的ThreadLocal的子类
 * @author skywalker
 *
 * @param <T> 存储的数据的类型
 */
public class ManagedThreadLocal<T> {

	private static volatile Queue<WeakReference<ManagedThreadLocal<?>>> instances = 
			new ConcurrentLinkedQueue<WeakReference<ManagedThreadLocal<?>>>();
	
	private volatile ThreadLocal<T> threadLocal;
	
	private ManagedThreadLocal(InitialValueProvider<T> provider) {
		threadLocal = new ThreadLocal<T>() {
			@Override
			protected T initialValue() {
				return provider.initialValue();
			}
		};
	}

	public static <T> ManagedThreadLocal<T> newInstance(InitialValueProvider<T> provider) {
		ManagedThreadLocal<T> mtl = new ManagedThreadLocal<T>(provider);
		instances.add(new WeakReference<ManagedThreadLocal<?>>(mtl));
		return mtl;
	}
	
	public static <T> ManagedThreadLocal<T> newInstance() {
		return newInstance(new InitialValueProvider<T>());
	}
	
	public void set(T value) {
		threadLocal.set(value);
	}
	
	public T get() {
		return threadLocal.get();
	}
	
	public void remove() {
		threadLocal.remove();
		threadLocal = null;
	}
	
	/**
	 * 清除所有的ThreadLocal实例，关键方法，可以在ServletContextListener的contextDestroyed方法中调用
	 */
	public static void removeAll() {
		WeakReference<ManagedThreadLocal<?>> reference;
		ManagedThreadLocal<?> mtl = null;
 		while ((reference = instances.poll()) != null) {
			mtl = reference.get();
			if (mtl != null) {
				mtl.remove();
			}
		}
		
	}
	
	/**
	 * ThreadLocal初始化器
	 * @author skywalker
	 *
	 * @param <T>
	 */
	public static class InitialValueProvider<T> {
		protected T initialValue() {
			return null;
		}
	}
	
}
