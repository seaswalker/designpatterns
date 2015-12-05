package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 访问他人信息的代理
 * @author skywalker
 *
 */
public class NoOwnerHandler implements InvocationHandler {

	//被代理对象
	private PersonBean person;
	
	public NoOwnerHandler(PersonBean person) {
		this.person = person;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		String methodName = method.getName();
		if(methodName.startsWith("get") || methodName.equals("setRato")) {
			return method.invoke(person, args);
		}else {
			throw new IllegalAccessException();
		}
	}
	
}
