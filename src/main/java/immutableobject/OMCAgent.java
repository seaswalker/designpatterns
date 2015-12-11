package immutableobject;

/**
 * 处理彩信中心、路由表的变更
 * @author skywalker
 *
 */
public class OMCAgent extends Thread {

	@Override
	public void run() {
		//数据库是否改变
		boolean isTableModificationMsg = false;
		String updatedTableName = null;
		while (true) {
			if (isTableModificationMsg) {
				if ("MSCInfo".equals(updatedTableName)) {
					//更新路由表
					MMSCRouter.setInstance(new MMSCRouter());
				}
			}
		}
	}
	
}
