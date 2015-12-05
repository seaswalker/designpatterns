package cache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * dao层---实现三种策略的读写方式
 * 此类并不是线程安全的
 * @author skywalker
 *
 */
public class UserAccountDao {

	private static final Logger logger = LogManager.getLogger(UserAccountDao.class);
	
	private LRUCache cache;
	private CachePolicy policy;
	
	public UserAccountDao(boolean useMongoDB, int capacity) {
		this(useMongoDB, capacity, null);
	}
	
	public UserAccountDao(boolean useMongoDB, int capacity, CachePolicy policy) {
		initCapacity(capacity);
		initDB(useMongoDB);
		this.policy = policy;
	}
	
	/**
	 * 初始化缓存
	 * @param capacity
	 */
	private void initCapacity(int capacity) {
		if (cache == null) {
			cache = new LRUCache(capacity);
		} else {
			cache.setCapacity(capacity);
		}
	}
	
	/**
	 * 初始化DBManager
	 * @param useMongoDB 是否使用MongoDB
	 */
	private void initDB(boolean useMongoDB) {
		if (useMongoDB) {
			DBManager.connect();
		} else {
			DBManager.createVirtualDB();
		}
	}
	
	/**
	 * 首先检查缓存，如果没有查询数据库，把结果放入缓存
	 * @param userId
	 * @return
	 */
	private UserAccount readThrough(String userId) {
		UserAccount userAccount = cache.get(userId);
		if (userAccount == null) {
			logger.info(userId + ": missed");
			userAccount = DBManager.read(userId);
			if (userAccount != null) {
				cache.set(userId, userAccount);
			}
		}
		return userAccount;
	}
	
	/**
	 * 如果缓存中有，那么数据库中必定也有，那么应该更新数据库和缓存
	 * 如果缓存中没有，不知道数据库中有没有，所以调用upsert方法，同时加入缓存
	 * @param userAccount
	 */
	private void writeThrough(UserAccount userAccount) {
		DBManager.upsert(userAccount);
		cache.set(userAccount.getUserId(), userAccount);
	}
	
	/**
	 * <p>如果缓存中存在，那么更新数据库，同时使缓存失效</p>
	 * <p>如果缓存没有，那么直接upsert数据库即可</p>
	 * @param userAccount
	 */
	private void writeAround(UserAccount userAccount) {
		if (cache.contains(userAccount.getUserId())) {
			DBManager.update(userAccount);
			cache.invalidate(userAccount.getUserId());
		} else {
			DBManager.upsert(userAccount);
		}
	}

	/**
	 * 如果缓存已满，那么将最后一个存入数据库，然后把参数加入缓存
	 * @param userAccount
	 */
	private void writeBehind(UserAccount userAccount) {
		if (cache.isFull() && !cache.contains(userAccount.getUserId())) {
			UserAccount lru = cache.getLRU();
			DBManager.write(cache.getLRU());
			logger.info(lru.getUserId() + ": flushed into database");
		}
		cache.set(userAccount.getUserId(), userAccount);
	}
	
	/**
	 * 和readThrough不同的就是，这个从数据库查出数据后，会检查缓存是否已满，如果已满
	 * 会把LRU元素存入数据库，而readThrough中就直接干掉了
	 * @param userId
	 * @return
	 */
	private UserAccount readThroughWithWriteBackPolicy(String userId) {
		UserAccount userAccount = cache.get(userId);
		if (userAccount == null) {
			logger.info(userId + ": missed");
			userAccount = DBManager.read(userId);
			if (userAccount != null) {
				if (cache.isFull()) {
					DBManager.upsert(cache.getLRU());
				}
				cache.set(userId, userAccount);
			}
		}
		return userAccount;
	}
	
	/**
	 * 查询，根据当前的CachePolicy执行不同的策略
	 * @param userId
	 * @return
	 */
	public UserAccount find(String userId) {
		if (policy == null) {
			throw new IllegalStateException("The CachePolicy hasn't specified yet");
		}  else {
			return policy == CachePolicy.BEHIND ? readThroughWithWriteBackPolicy(userId) : readThrough(userId);
		}
	}
	
	public void save(UserAccount userAccount) {
		if (policy == null) {
			throw new IllegalStateException("The CachePolicy hasn't specified yet");
		} else if (policy == CachePolicy.BEHIND) {
			writeBehind(userAccount);
		} else if (policy == CachePolicy.AROUND) {
			writeAround(userAccount);
		} else {
			writeThrough(userAccount);
		}
	}
	
	public void clearCache() {
		if (cache != null) cache.clear();
	}
	
	/**
	 * 把缓存中的数据存入数据库
	 */
	public void flushCache() {
		if (cache != null) {
			logger.info("flushing into database...");
			for (UserAccount userAccount : cache.getCacheDataInListForm()) {
				DBManager.upsert(userAccount);
			}
		}
	}

	public CachePolicy getPolicy() {
		return policy;
	}

	public void setPolicy(CachePolicy policy) {
		this.policy = policy;
	}
	
}
