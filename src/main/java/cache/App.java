package cache;

public class App {

	public static void main(String[] args) {
		UserAccountDao dao = new UserAccountDao(false, 2, CachePolicy.BEHIND);
		dao.save(new UserAccount("1", "skywalker", ""));
		dao.save(new UserAccount("2", "Tom", ""));
		dao.save(new UserAccount("3", "Jack", ""));
	}
	
}
