package cache;

/**
 * 缓存策略
 * @author skywalker
 *
 */
public enum CachePolicy {
	/*
	 * 最常用的策略:
	 * 写的时候，在一个事物内向缓存和数据库写入
	 * 读的时候，先从缓存中查找，如果没有再从数据库读取，同时添加到缓存(三个策略的读都是一样的)
	 */
	THROUGH,
	/*
	 * 直接写入数据库
	 */
	AROUND,
	/*
	 * 仅写入到缓存，只有缓存满了的时候才会写到数据库中
	 */
	BEHIND
}
