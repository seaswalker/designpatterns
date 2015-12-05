package businessdelegate;

public class BusinessLookupService {

	private EJBService ejbService;
	private JMSService jmsService;
	
	public void setEjbService(EJBService ejbService) {
		this.ejbService = ejbService;
	}

	public void setJmsService(JMSService jmsService) {
		this.jmsService = jmsService;
	}
	
	public BusinessService getService(ServiceType type) {
		if (type == ServiceType.EJB) {
			return ejbService;
		} else if (type == ServiceType.JMS) {
			return jmsService;
		}
		return null;
	}
	
}
