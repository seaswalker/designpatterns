package proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * 测试动态代理
 * @author skywalker
 *
 */
public class Client {

	public static void main(String[] args) {
		PersonBeanImpl person = new PersonBeanImpl("skywalker", "放屁", "年方99", 100);
		
		PersonBean owner = (PersonBean) Proxy.newProxyInstance(Client.class.getClassLoader(), person.getClass().getInterfaces(),
				new OwnerHandler(person));
		
		System.out.println(owner.getName());
		owner.setInterests("睡觉");
		
		try {
			owner.setRato(99);
		}catch(Exception e) {
			System.out.println("别耍花招");
			//e.printStackTrace();
		}
		
		System.out.println("测试别人开始");
		
		//别人
		PersonBean noOwner = (PersonBean) Proxy.newProxyInstance(Client.class.getClassLoader(), 
				person.getClass().getInterfaces(), new NoOwnerHandler(person));
		System.out.println(noOwner.getInterests());
		noOwner.setRato(99);
		try {
			noOwner.setInterests("呵呵");
		}catch(Exception e) {
			System.out.println("别人的信息你改不了");
		}
	}
	
}
