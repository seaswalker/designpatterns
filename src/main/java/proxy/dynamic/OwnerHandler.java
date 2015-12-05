package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class OwnerHandler implements InvocationHandler {
	
	//���������
	private PersonBean person;
	
	public OwnerHandler(PersonBean person) {
		this.person = person;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		String methodName = method.getName();
		if(methodName.equals("setRato")) {
			throw new IllegalAccessException("�����޸�����");
		}else if(methodName.startsWith("get") || methodName.startsWith("set")) {
			return method.invoke(person, args);
		}
		return null;
	}

}
