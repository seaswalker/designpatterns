package cache;

import java.util.HashMap;
import java.util.Map;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;

/**
 * 数据库管理，如果使用MongoDB，那么将会连接到数据库，否则使用一个HashMap作为"虚拟数据库"
 * @author skywalker
 *
 */
public class DBManager {

	private static boolean useMongoDB;
	private static Map<String, UserAccount> virtualDB;
	private static MongoClient client;
	private static MongoDatabase database;
	//使用的数据库名
	private static final String DBNAME = "test";
	
	/**
	 * 使用虚拟数据库
	 */
	public static void createVirtualDB() {
		useMongoDB = false;
		virtualDB = new HashMap<String, UserAccount>();
	}
	
	/**
	 * 连接到MongoDB
	 */
	public static void connect() {
		useMongoDB = true;
		client = new MongoClient();
		database = client.getDatabase(DBNAME);
	}
	
	/**
	 * 从数据库读取
	 * @param userId 数据库存储的主键
	 * @return
	 */
	public static UserAccount read(String userId) {
		if (useMongoDB) {
			if (database == null) {
				connect();
			}
			FindIterable<Document> iterable = database.getCollection("user_account").find(new Document("userId", userId));
			if (iterable != null) {
				Document doc = iterable.first();
				return new UserAccount(userId, doc.getString("userName"), doc.getString("additionalInfo"));
			}
			return null;
		} else {
			if (virtualDB == null) {
				createVirtualDB();
			}
			return virtualDB.get(userId);
		}
	}
	
	/**
	 * 保存数据
	 * @param userAccount
	 */
	public static void write(UserAccount userAccount) {
		if (useMongoDB) {
			if (database == null) {
				connect();
			}
			database.getCollection("user_account").insertOne(new Document("userId", userAccount.getUserId())
					.append("userName", userAccount.getUserName()).append("additionalInfo", userAccount.getAdditionalInfo()));
		} else {
			if (virtualDB == null) {
				createVirtualDB();
			}
			virtualDB.put(userAccount.getUserId(), userAccount);
		}
	}
	
	/**
	 * 更新
	 * @param userAccount
	 */
	public static void update(UserAccount userAccount) {
		if (useMongoDB) {
			if (database == null) {
				connect();
			}
			database.getCollection("user_account").updateOne(new Document("userId", userAccount.getUserId()),
					//$set正是为了避免MongoDB的update方法会替换这个坑
					new Document("$set", new Document("userName", userAccount.getUserName()).append("additionalInfo", userAccount.getAdditionalInfo())));
		} else {
			if (virtualDB == null) {
				createVirtualDB();
			}
			virtualDB.put(userAccount.getUserId(), userAccount);
		}
	}
	
	/**
	 * 如果存在那么更新，否则insert
	 * @param userAccount
	 */
	public static void upsert(UserAccount userAccount) {
		if (useMongoDB) {
			if (database == null) {
				connect();
			}
			database.getCollection("user_account").updateOne(new Document("userId", userAccount.getUserId()),
					//$set正是为了避免MongoDB的update方法会替换这个坑
					new Document("$set", new Document("userName", userAccount.getUserName()).append("additionalInfo", userAccount.getAdditionalInfo())), 
					new UpdateOptions().upsert(true));
		} else {
			if (virtualDB == null) {
				createVirtualDB();
			}
			virtualDB.put(userAccount.getUserId(), userAccount);
		}
	}
	
}
