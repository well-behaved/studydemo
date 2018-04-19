
import java.util.*;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisDemo {
    private Jedis jedis;

    @Before
    public void setup() {
        //连接redis服务器，192.168.0.100:6379
        jedis = new Jedis("localhost", 6379);
        //权限认证
//        jedis.auth("admin");
    }
    @Test
    public  void lockDemo(){
        System.out.println(jedis.set("xueDemo","这是一个分布式锁测试","NX"));
        System.out.println("over");
    }

    /**
     * redis 加锁
     *  低版本redis的set不支持如果存在就赋值&&设置过期时间命令 所以需要两个命令 swtnx和expire
     * @param lockName 锁名称
     * @param lockValue 锁值
     * @param tryTime 尝试获得锁的最长时间 （秒）
     * @param seconds 锁最多持有的时间 （秒）
     */
    public boolean addLock(String lockName, String lockValue, int tryTime, int seconds) throws InterruptedException {
        // 是否得到锁
        boolean isSuccess = false;
        // 最大尝试得到锁的时间
        Date endDate = new Date(new Date().getTime() + tryTime * 1000);
        // 循环获取锁
        while (new Date().getTime() < endDate.getTime()) {
            if (jedis.setnx(lockName, lockValue) == 1) {// 如果得到锁
                isSuccess = true;
                break;
            }else {
                Thread.sleep(500);
            }
        }
        /*
         * 设置超时时间  若在这里程序突然崩溃，则无法设置过期时间，将发生死锁，所以如果没得到锁需要检测锁是否有超时机制
         */
        if(isSuccess){
            jedis.expire(lockName, seconds);
        }else{//没有得到锁，则判断上次锁有没有被正常设置超时时间
            if (jedis.exists(lockName)) {// 如果存在
                if (jedis.ttl(lockName) < 0) {// 如果没有设置时间,设置过期时间
                    jedis.expire(lockName, seconds);
                }
            }
        }
        return isSuccess;
    }

    /**
     *
     * @param lockName 锁名称
     * @param lockValue 锁值
     * @return
     */
    private boolean releaseLock(String lockName, String lockValue) {
        // 是否成功释放锁
        boolean isSuccess = false;
        /*
         * 校验锁当前状态
         * 1.超时被自动删除但无其他人使用，可能已经用过
         * 2.超时自动删除后已经被他人使用
         * 3.存在正常
         */
        if (jedis.exists(lockName)) {

        }else{//超时被自动删除但当前无其他人使用

        }
        jedis.get(lockName);
        jedis.del(lockName);
        isSuccess = true;
        return isSuccess;
    }




    /**
     * redis存储字符串
     */
    @Test
    public void testString() {
        //-----添加数据----------
        jedis.set("name","xinxin");//向key-->name中放入了value-->xinxin
        System.out.println(jedis.get("name"));//执行结果：xinxin


        jedis.append("name", " is my lover"); //拼接
        System.out.println(jedis.get("name"));

        jedis.del("name");  //删除某个键
        System.out.println(jedis.get("name"));
        //设置多个键值对
        jedis.mset("name","liuling","age","23","qq","476777XXX");
        jedis.incr("age"); //进行加1操作
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));

    }

    /**
     * redis操作Map
     */
    @Test
    public void testMap() {
        //-----添加数据----------
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "xinxin");
        map.put("age", "22");
        map.put("qq", "123456");
        jedis.hmset("user",map);
        //取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List
        //第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
        List<String> rsmap = jedis.hmget("user", "name", "age", "qq");
        System.out.println(rsmap);

        //删除map中的某个键值
        jedis.hdel("user","age");
        System.out.println(jedis.hmget("user", "age")); //因为删除了，所以返回的是null
        System.out.println(jedis.hlen("user")); //返回key为user的键中存放的值的个数2
        System.out.println(jedis.exists("user"));//是否存在key为user的记录 返回true
        System.out.println(jedis.hkeys("user"));//返回map对象中的所有key
        System.out.println(jedis.hvals("user"));//返回map对象中的所有value

        Iterator<String> iter=jedis.hkeys("user").iterator();
        while (iter.hasNext()){
            String key = iter.next();
            System.out.println(key+":"+jedis.hmget("user",key));
        }
    }

    /**
     * jedis操作List
     */
    @Test
    public void testList(){
        //开始前，先移除所有的内容
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework",0,-1));
        //先向key java framework中存放三条数据
        jedis.lpush("java framework","spring");
        jedis.lpush("java framework","struts");
        jedis.lpush("java framework","hibernate");
        //再取出所有数据jedis.lrange是按范围取出，
        // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
        System.out.println(jedis.lrange("java framework",0,-1));

        jedis.del("java framework");
        jedis.rpush("java framework","spring");
        jedis.rpush("java framework","struts");
        jedis.rpush("java framework","hibernate");
        System.out.println(jedis.lrange("java framework",0,-1));
    }

    /**
     * jedis操作Set
     */
    @Test
    public void testSet(){
        //添加
        jedis.sadd("user","liuling");
        jedis.sadd("user","xinxin");
        jedis.sadd("user","ling");
        jedis.sadd("user","zhangxinxin");
        jedis.sadd("user","who");
        //移除noname
        jedis.srem("user","who");
        System.out.println(jedis.smembers("user"));//获取所有加入的value
        System.out.println(jedis.sismember("user", "who"));//判断 who 是否是user集合的元素
        System.out.println(jedis.srandmember("user"));
        System.out.println(jedis.scard("user"));//返回集合的元素个数
    }

    @Test
    public void test() throws InterruptedException {
        //jedis 排序
        //注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）
        jedis.del("a");//先清除数据，再加入数据进行测试
        jedis.rpush("a", "1");
        jedis.lpush("a","6");
        jedis.lpush("a","3");
        jedis.lpush("a","9");
        System.out.println(jedis.lrange("a",0,-1));// [9, 3, 6, 1]
        System.out.println(jedis.sort("a")); //[1, 3, 6, 9]  //输入排序后结果
        System.out.println(jedis.lrange("a",0,-1));
    }


}