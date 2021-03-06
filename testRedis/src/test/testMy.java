package test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import util.RedisUtil;

public class testMy {

	public static void main(String[] args) {

		Jedis jedis = getJedis();
		// 权限认证
		jedis.auth("3158123000");
		// 操作string
		// updateString(jedis);
		// 操作list
		// testList(jedis);
		// 操作set
		// testSet(jedis);
		// 操作hash
		//testHash(jedis);
		// 有序分数集
		testSortSet(jedis);
	}
	
	/**
	 * 有序分数集（排行榜）
	 * @param jedis
	 */
	private static void testSortSet(Jedis jedis){
		jedis.zadd("sort1",10.1,"value1" ); // 添加一条分数集
		jedis.zadd("sort1",9.1,"value2" ); // 添加一条分数集
		jedis.zadd("sort1",11.1,"value3" ); // 添加一条分数集
		jedis.zadd("sort1",15.1,"value4" ); // 添加一条分数集
		jedis.zadd("sort1",17.1,"value5" ); // 添加一条分数集
		jedis.zadd("sort1",21.1,"value6" ); // 添加一条分数集
		jedis.zadd("sort1",54.2,"value7" ); // 添加一条分数集
		System.out.println("一共出价的人数是："+jedis.zcard("sort1"));
		// 排序
		System.out.println("从低到高排【小大到大】"+jedis.zrange("sort1",0,jedis.zcard("sort1")-1)); // 获取a 到 b的排名(相同数据根据value值判断)
		jedis.zadd("sort1",1000.1,"value1" ); // 添加一条分数集
		// 排序
		System.out.println("增量后【从大到小】value1是"+(jedis.zrevrank("sort1","value1")+1)+"名"); // 获取排序
		// 排序
		System.out.println("新排行榜【从大到小】"+jedis.zrevrange("sort1",0,jedis.zcard("sort1")-1)); // 获取a 到 b的排名(相同数据根据value值判断)
	}
	/**
	 * hash类型（散列类型）
	 * @param jedis
	 */
	private static void testHash(Jedis jedis){
		jedis.hset("hash1","key1", "爱护上");// 存入一个hash
		System.out.println(jedis.hget("hash1", "key1")); // 取出一个hash
		jedis.hset("hash1","key2", "13岁");// 存入一个hash
		jedis.hset("hash1","key3", "男");// 存入一个hash
		System.out.println("所拥有的属性数量是："+jedis.hlen("hash1")); //获取hash长度
		System.out.println("打印出选定属性："+jedis.hmget("hash1", "key1","key2","key3")); //获取hash长度
	}
	/**
	 * 操作String
	 * 
	 * @param jedis
	 */
	private static void updateString(Jedis jedis) {

		// -----添加数据----------
		jedis.set("name", "liujinjin");// 向key-->name中放入了value-->xinxin
		System.out.println(jedis.get("name"));// 执行结果：xinxin

		jedis.append("name", " is my lover"); // 拼接
		System.out.println(jedis.get("name"));
		// 删除string
		jedis.del("name");
		System.out.println(jedis.get("name"));

	}

	/**
	 * 操作List（队列）
	 * 
	 * @param jedis
	 */
	private static void testList(Jedis jedis) {
		// 开始前，先移除所有的内容
		jedis.del("java framework");
		System.out.println(jedis.lrange("java framework", 0, -1));
		// 先向key java framework中存放三条数据
		jedis.lpush("java framework", "spring");
		jedis.lpush("java framework", "struts");
		jedis.lpush("java framework", "hibernate");
		// 再取出所有数据jedis.lrange是按范围取出，
		// 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
		System.out.println(jedis.lrange("java framework", 0, -1));
		System.out.println(jedis.rpop("java framework"));
		System.out.println("右边去掉一个后" + jedis.lrange("java framework", 0, -1));

		jedis.del("java framework");
		jedis.rpush("java framework", "spring");
		jedis.rpush("java framework", "struts");
		jedis.rpush("java framework", "hibernate");
		System.out.println(jedis.lrange("java framework", 0, -1));
		System.out.println(jedis.lpop("java framework"));
		System.out.println("左边去掉一个后" + jedis.lrange("java framework", 0, -1));
	}

	/**
	 * 操作set
	 * 
	 * @param jedis
	 */
	private static void testSet(Jedis jedis) {
		// 添加
		jedis.sadd("user", "lingweihao");
		jedis.sadd("user", "liujingjing");
		jedis.sadd("user", "xujie");
		jedis.sadd("user", "xujie");
		jedis.sadd("user", "xujie");
		jedis.sadd("user", "xujie");
		jedis.sadd("user", "xujie");
		jedis.sadd("user", "xujie");
		jedis.sadd("user", "luochengyang");
		jedis.sadd("user", "who");
		// 移除noname
		jedis.srem("user", "who");
		System.out.println(jedis.smembers("user"));// 获取所有加入的value
		System.out.println(jedis.sismember("user", "who"));// 判断 who
															// 是否是user集合的元素
		System.out.println(jedis.srandmember("user"));// 获取随机数
		System.out.println(jedis.scard("user"));// 返回集合的元素个数
	}

	
	
	/**
	 * 获取jedis
	 * 
	 * @return
	 */
	private static Jedis getJedis() {
		JedisPool jedisPool = null;
		// Redis服务器IP
		String ADDR = "120.55.61.146";

		// Redis的端口号
		int PORT = 7200;

		// 访问密码
		String AUTH = "3158123000";

		// 可用连接实例的最大数目，默认值为8；
		// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
		int MAX_ACTIVE = 1024;

		// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
		int MAX_IDLE = 200;

		// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
		int MAX_WAIT = 10000;
		// 存在时间
		int TIMEOUT = 1000 * 60 * 60 * 6;

		// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
		boolean TEST_ON_BORROW = true;
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxActive(1000 * 60 * 60 * 6);
			config.setMaxIdle(MAX_IDLE);
			config.setMaxWait(30000);
			config.setTestOnBorrow(true);
			jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (jedisPool != null) {
				Jedis resource = jedisPool.getResource();
				return resource;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
