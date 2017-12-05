package com.example.conf;
/**
* @discription 
* @author 作者  yepinjia
* @version 创建时间：2017年6月28日 上午9:55:49
* 
*/

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableCaching
@PropertySource(value = "classpath:redis.properties")
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig extends CachingConfigurerSupport {
	
	private int minIdle;
	private int maxIdle;
	private long maxWaitMillis;
	private int maxTotal;
	private int timeout;
	private String hostName;
	private String password;
	private int port;
	private int dataBase;
	
	@Bean(name = "jedisPoolConfig")
	@Primary // 当一个接口有多个实现类时，加上这个注解表明，要加载这个实现类
	public JedisPoolConfig getRedisConfig() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMinIdle(minIdle);
		config.setMaxIdle(maxIdle);
		config.setMaxWaitMillis(maxWaitMillis);
		config.setMaxTotal(maxTotal);
		return config;
	}

	@Bean(name="jedisConnectionFactory")
	public JedisConnectionFactory getConnectionFactory(@Qualifier("jedisPoolConfig") JedisPoolConfig config) {
		
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setTimeout(timeout);
		factory.setHostName(hostName);
		factory.setPassword(password);
		factory.setPort(port);
		factory.setDatabase(dataBase);
		factory.setPoolConfig(config);
		
		return factory;
	}

	@Bean(name="redisTemplate")
	public RedisTemplate<?, ?> getRedisTemplate(@Qualifier("jedisConnectionFactory") JedisConnectionFactory factory) {
		
		RedisTemplate<?, ?> redisTemplate = new StringRedisTemplate(factory);
		
		return redisTemplate;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public long getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(long maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getDataBase() {
		return dataBase;
	}

	public void setDataBase(int dataBase) {
		this.dataBase = dataBase;
	}
	
	
}
