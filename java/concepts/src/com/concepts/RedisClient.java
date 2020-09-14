package com.concepts;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

public class RedisClient {

    private static Set<HostAndPort> connectionPoints = new HashSet<>();
    static {

        connectionPoints.add(new HostAndPort("svclu-dvcch0001", 30001));
        connectionPoints.add(new HostAndPort("svclu-dvcch0001", 30002));
        connectionPoints.add(new HostAndPort("svclu-dvcch0001", 30003));
        connectionPoints.add(new HostAndPort("svclu-dvcch0001", 30004));
        connectionPoints.add(new HostAndPort("svclu-dvcch0001", 30005));
        connectionPoints.add(new HostAndPort("svclu-dvcch0001", 30006));
    }

    public static void main(String[] args) throws Exception {

        // printValue("PLAYPEN:clucasqa1:cluDocumentExternalId:", "27741");

        // printValue("PLAYPEN:CLUdev4:businessEntityByName:", "Training");

        // printKeys();
        GenericJackson2JsonRedisSerializer deserializer = new GenericJackson2JsonRedisSerializer();
        try (JedisCluster cluster = new JedisCluster(connectionPoints)) {
            System.out.println(cluster.get("PLAYPEN:CLUdev9:businessEntityByName:\"12343215678\""));
            BusinessEntity businessEntity = deserializer.deserialize(
                    cluster.get("PLAYPEN:CLUdev9:businessEntityByName:\"12343215678\"").getBytes(),
                    BusinessEntity.class);
            System.out.println(businessEntity);
        }

    }

    private static void printValue(String prefixText, Object keyText) throws Exception {
        String key = prefixText + keyText;

        JdkSerializationRedisSerializer serializer = new JdkSerializationRedisSerializer();
        byte[] rawKey = serializer.serialize(keyText);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        byte[] prefix = stringRedisSerializer.serialize(prefixText);

        byte[] prefixedKey = Arrays.copyOf(prefix, prefix.length + rawKey.length);
        System.arraycopy(rawKey, 0, prefixedKey, prefix.length, rawKey.length);
        // System.out.println(new String(prefixedKey));

        try (JedisCluster cluster = new JedisCluster(connectionPoints)) {
            if (cluster.exists(prefixedKey)) {
                System.out.println(key + "\t" + serializer.deserialize(cluster.get(prefixedKey)));
                // System.out.println(cluster.del(prefixedKey));

            }
            else {
                System.out.println("Could not find key: " + key);
            }
        }
    }

    private static void printKeys() throws Exception {
        JdkSerializationRedisSerializer serializer = new JdkSerializationRedisSerializer();
        try (JedisCluster cluster = new JedisCluster(connectionPoints)) {
            ScanParams params = new ScanParams();
            params.match("PLAYPEN:CLUdev9:businessEntityByName:*");
            params.count(100);
            Collection<JedisPool> jedisPool = cluster.getClusterNodes().values();
            for (JedisPool pool : jedisPool) {
                Jedis jedis = pool.getResource();
                // try (Jedis jedis = new Jedis("svclu-dvcch0001", 30001)) {
                ScanResult<byte[]> byteResult = jedis.scan("0".getBytes(), params);
                ScanResult<String> result = jedis.scan("0", params);
                for (int i = 0; i < result.getResult().size(); i++) {
                    String key = result.getResult().get(i);
                    byte[] byteKey = byteResult.getResult().get(i);

                    int separatorIndex = StringUtils.ordinalIndexOf(key, ":", 3) + 1;
                    int endIndex = separatorIndex;
                    String prefixKey = key.substring(0, endIndex);

                    int length = byteKey.length - endIndex;
                    byte[] rawKeyBytes = new byte[length];
                    System.arraycopy(byteKey, endIndex, rawKeyBytes, 0, length);
                    try {
                        Object rawKey = serializer.deserialize(rawKeyBytes);
                        // System.out.println(prefixKey + rawKey);
                        printValue(prefixKey, rawKey);
                    }
                    catch (Exception e) {
                        // e.printStackTrace();
                        System.out.println("=====" + key + "\t" + e.getMessage());
                    }
                }
                // System.out.println(cluster.exists(prefixedKey));
            }
        }
    }
}