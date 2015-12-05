package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class OwnerHandler implements InvocationHandler {
	
	//被代理对象
	private PersonBean person;
	
	public OwnerHandler(PersonBean person) {
		this.person = person;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		String methodName = method.getName();
		if(methodName.equals("setRato")) {
			throw new IllegalAccessException("不能修改人气");
		}else if(methodName.startsWith("get") || methodName.startsWith("set")) {
			return method.invoke(person, args);
		}
		return null;
	}

}
