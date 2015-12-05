package businessdelegate;

/**
 * 测试，此模式在客户端和业务层之间加了一层抽象(BusinessDelegate)，这样可以解耦
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
		
		//切换类型
		delegate.setServiceType(ServiceType.EJB);
		client.doTask();
	}
	
}
