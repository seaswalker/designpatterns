package singleton;

/**
 * 第三种方式，需要时加载，并且只有在第一次初始化时才同步
 * 双重检查加锁
 * @author skywalker
 *
 */
public class S3 {
	
	//这正是volatite关键字常用场景之一，另一个是状态标志量
	private volatile static S3 s3;
	
	private S3() {}
	
	public static S3 getInstance() {
		if(s3 == null) {
			synchronized (S3.class) {
				//第二次判断空
				if(s3 == null) {
					s3 = new S3();
				}
			}
		}
		return s3;
	}
	
}
