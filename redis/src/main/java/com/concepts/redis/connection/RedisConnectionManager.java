package com.concepts.redis.connection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concepts.redis.properties.ApplicationProperties;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

@Component
public class RedisConnectionManager {

    @Autowired
    private ApplicationProperties applicationProperties;

    public Collection<JedisPool> getClusterNodes() {
        return getRedisCluster().getClusterNodes().values();
    }

    public JedisCluster getRedisCluster() {
        Set<HostAndPort> connectionPoints = new HashSet<>();
        String[] hostsConfig = applicationProperties.getHostsConfig().split(",");
        for (String hostAndPort : hostsConfig) {
            String[] data = hostAndPort.split(":");
            connectionPoints.add(new HostAndPort(data[0], Integer.valueOf(data[1])));
        }
        return new JedisCluster(connectionPoints);

    }

}
