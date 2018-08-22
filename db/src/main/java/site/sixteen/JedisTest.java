package site.sixteen;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

/**
 * Hello world!
 */
public class JedisTest {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.172.128",6379);
        jedis.auth("123456");
        System.out.println(jedis);
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        jedis.set("str1","hello world!");
        System.out.println(jedis.get("str1"));
        jedis.lpush("list1","1","2","3");
        System.out.println(jedis.lrange("list1",0,3));
        Set<String> keys =  jedis.keys("*");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key);
        }
        jedis.close();
    }
}
