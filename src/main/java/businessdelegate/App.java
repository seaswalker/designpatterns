package businessdelegate;

/**
 * ���ԣ���ģʽ�ڿͻ��˺�ҵ���֮�����һ�����(BusinessDelegate)���������Խ���
 * @author skywalker
 *
 */
public class App {

	public static void main(String[] args) {
		BusinessLookupService lookupService = new BusinessLookupService();
		lookupService.setEjbService(new EJBService());
		lookupService.setJmsService(new JMSService());
		BusinessDelegate delegate = new BusinessDelegate(lookupService);
		delegate.setServiceType(ServiceType.JMS);
		Client client = new Client(delegate);
		client.doTask();
		
		//�л�����
		delegate.setServiceType(ServiceType.EJB);
		client.doTask();
	}
	
}
