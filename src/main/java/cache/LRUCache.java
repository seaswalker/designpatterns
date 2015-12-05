package cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * LRU(最近最久未使用)算法
 * 注意这个Map + 双向链表的方式(LinkedHashMap其实就是这个原理)
 * @author skywalker
 *
 */
public class LRUCache {
	
	private static final Logger logger = LogManager.getLogger(LRUCache.class);
	
	private int capacity;
	private Map<String, Node> cache = new HashMap<String, Node>();
	//LRU链表的头结点、尾节点
	private Node head, tail;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * 在查找中缓存
	 * @param userId 缓存的key
	 * @return
	 */
	public UserAccount get(String userId) {
		Node node = cache.get(userId);
		if (node != null) {
			//只要有节点存在，那么head和tail必不为空
			//删除此节点
			removeNode(node);
			//此节点放到链表头部
			setHead(node);
			return node.value;
		}
		return null;
	}
	
	/**
	 * 加入缓存
	 * @param userId key
	 * @param userAccount
	 */
	public void set(String userId, UserAccount userAccount) {
		Node node = cache.get(userId);
		if (node != null) {
			node.value = userAccount;
		} else {
			node = new Node(userId, userAccount);
			//已经满了，删除尾节点
			if (isFull()) {
				cache.remove(tail.userId);
				logger.info("节点: " + tail.userId + "被移除");
				Node temp = tail;
				tail = tail.pre;
				tail.next = null;
				temp.pre = null;
			}
			cache.put(userId, node);
			logger.info("添加新节点: " + userId);
		}
		setHead(node);
	}
	
	/**
	 * 缓存中是否存在指定的key
	 * @param userId
	 * @return
	 */
	public boolean contains(String userId) {
		return cache.containsKey(userId);
	}
	
	/**
	 * 使特定的缓存失效
	 * @param userId 缓存的key
	 */
	public void invalidate(String userId) {
		Node node = cache.remove(userId);
		if (node != null) {
			removeNode(node);
			logger.info(userId + "失效");
		}
	}
	
	/**
	 * 清空缓存
	 */
	public void clear() {
		cache.clear();
		head = tail = null;
	}
	
	/**
	 * 以List的形式返回缓存中的所有数据，保持LRU顺序
	 * @return
	 */
	public List<UserAccount> getCacheDataInListForm() {
		List<UserAccount> list = new ArrayList<UserAccount>();
		Node node = head;
		while (node != null) {
			list.add(node.value);
			node = node.next;
		}
		return list;
	}
	
	/**
	 * 重新设置容量
	 * @param newCapacity 新容量
	 */
	public void setCapacity(int newCapacity) {
		if (newCapacity < capacity) {
			//简单处理，直接清空
			clear();
		}
		this.capacity = newCapacity;
	}
	
	/**
	 * 是否满了
	 * @return
	 */
	public boolean isFull() {
		return cache.size() >= capacity;
	}
	
	/**
	 * 返回LRU(tail)节点
	 * @return
	 */
	public UserAccount getLRU() {
		return tail.value;
	}
	
	/**
	 * 将node节点置为头结点
	 * @param node
	 */
	private void setHead(Node node) {
		node.next = head;
		if (head != null) {
			head.pre = node;
		} 
		head = node;
		if (tail == null) {
			tail = node;
		}
	}
	
	/**
	 * 移除节点
	 * @param node
	 */
	private void removeNode(Node node) {
		if (node.pre != null) {
			node.pre.next = node.next;
			if (node.next != null) {
				node.next.pre = node.pre;
			}
		} else {
			//pre为空，说明node就是头结点
			head = node.next;
			node.next = null;
			head.pre = null;
		}
	}
	
	/**
	 * LRU双向链表的节点(有造轮子的嫌疑)
	 * @author skywalker
	 *
	 */
	private static class Node {
		private String userId;
		private UserAccount value;
		private Node pre;
		private Node next;
		
		public Node(String userId, UserAccount value) {
			this.userId = userId;
			this.value = value;
		}
	}
	
}
