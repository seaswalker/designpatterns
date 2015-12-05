package businessdelegate;

/**
 * ÒµÎñÎ¯ÍÐ
 * @author skywalker
 *
 */
public class BusinessDelegate {

	private BusinessLookupService lookupService;
	private ServiceType serviceType;
	private BusinessService businessService;
	
	public BusinessDelegate(BusinessLookupService lookupService) {
		this.lookupService = lookupService;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}
	
	public void doTask() {
		businessService = lookupService.getService(serviceType);
		businessService.process();
	}
	
}
