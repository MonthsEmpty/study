package test.com.redis;

import redis.clients.jedis.Jedis;

public class RedisDemo {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("10.99.8.166",6379);
//		Jedis jedis = new Jedis("10.99.8.166");
//		jedis.auth("admin");
		jedis.set("name", "vincent");
		System.out.println(jedis.get("name"));
	}
}
