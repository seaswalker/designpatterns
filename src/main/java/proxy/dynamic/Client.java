package proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * ���Զ�̬����
 * @author skywalker
 *
 */
public class Client {

	public static void main(String[] args) {
		PersonBeanImpl person = new PersonBeanImpl("skywalker", "��ƨ", "�귽99", 100);
		
		PersonBean owner = (PersonBean) Proxy.newProxyInstance(Client.class.getClassLoader(), person.getClass().getInterfaces(),
				new OwnerHandler(person));
		
		System.out.println(owner.getName());
		owner.setInterests("˯��");
		
		try {
			owner.setRato(99);
		}catch(Exception e) {
			System.out.println("��ˣ����");
			//e.printStackTrace();
		}
		
		System.out.println("���Ա��˿�ʼ");
		
		//����
		PersonBean noOwner = (PersonBean) Proxy.newProxyInstance(Client.class.getClassLoader(), 
				person.getClass().getInterfaces(), new NoOwnerHandler(person));
		System.out.println(noOwner.getInterests());
		noOwner.setRato(99);
		try {
			noOwner.setInterests("�Ǻ�");
		}catch(Exception e) {
			System.out.println("���˵���Ϣ��Ĳ���");
		}
	}
	
}
