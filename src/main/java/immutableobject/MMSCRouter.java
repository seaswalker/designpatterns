package immutableobject;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 短信中心路由表
 * @author skywalker
 *
 */
public class MMSCRouter {

	private static volatile MMSCRouter instance = new MMSCRouter();
	//维护手机号前缀和短信中心的关系
	private final Map<String, MMSCInfo> routerMap;
	
	public MMSCRouter() {
		this.routerMap = retrieveRouteMapFromDB();
	}
	
	/**
	 * 从数据库读取映射关系，再次只是模拟实现
	 * @return 路由表
	 */
	private Map<String, MMSCInfo> retrieveRouteMapFromDB() {
		return new HashMap<String, MMSCInfo>();
	}
	
	/**
	 * 整个替换路由表
	 * @param newInstance
	 */
	public static void setInstance(MMSCRouter newInstance) {
		instance = newInstance;
	}
	
	public static MMSCRouter getInstance() {
		return instance;
	}
	
	/**
	 * 根据手机号前缀查找短信中心
	 * @param msisdnPrefix 手机号前缀
	 * @return 短信中心
	 */
	public MMSCInfo getMMSC(String msisdnPrefix) {
		return routerMap.get(msisdnPrefix);
	}
	
	public Map<String, MMSCInfo> getRouterMap() {
		return Collections.unmodifiableMap(routerMap);
	}
	
}
