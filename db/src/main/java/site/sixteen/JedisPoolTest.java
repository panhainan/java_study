package site.sixteen;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class JedisPoolTest {

    public static void main(String[] args) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMaxIdle(10);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"192.168.172.128",6379);
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.auth("123456");
            jedis.set("name", "sixteen");
            System.out.println(jedis.get("name"));
        }
        jedisPool.close();
    }
}
