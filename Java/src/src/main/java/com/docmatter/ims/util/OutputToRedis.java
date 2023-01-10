package com.docmatter.ims.util;

import org.apache.catalina.Pipeline;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

import java.util.Map;

public class OutputToRedis {

    public void writeTest(Map<Integer, Integer> map, int max) {
            long startTime = System.nanoTime();
            for(int i = 1; i <= max; i++) {
                Integer a = new Integer(i);
                map.put(a, a);
            }
            long endTime = System.nanoTime();
            double diff = (endTime - startTime)/(double)1000000000;
            System.out.println("Time taken to write (RAM): " + diff);

//            Jedis jedis = new Jedis("localhost", 6379);
//            jedis.flushAll();
//            Pipeline p = jedis.pipelined();
//            startTime = System.nanoTime();
//            for(int i = 1; i <= max; i++) {
//                String a = Integer.toString(i);
//                p.set(a, a);
//            }
//            p.sync();
//            endTime = System.nanoTime();
//            diff = (endTime - startTime)/(double)1000000000;
//            System.out.println("Time taken to write (Redis): " + diff);
//            jedis.close();



    }
}
