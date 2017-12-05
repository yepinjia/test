package com.example.conf;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;

/**
 * @discription
 * @author 作者 yepinjia
 * @version 创建时间：2017年6月3日 上午9:10:04
 * 
 */
@Configuration
@PropertySource(value = "classpath:db.properties")
@ConfigurationProperties(prefix = "db.transferwedeu")
@MapperScan(basePackages = "com.example.dao.firstDao", sqlSessionTemplateRef = "firstSqlSessionTemplete")
public class FirstDataSouraceConfig {

	private Logger logger = LoggerFactory.getLogger(FirstDataSouraceConfig.class);

	private String jdbcUrl;

	private String dbType;

	private String username;

	private String password;

	private String driverClass;

	private int initialSize;

	private int minIdle;

	private int maxActive;

	private int maxWait;

	private int timeBetweenEvictionRunsMillis;

	private int minEvictableIdleTimeMillis;

	private String validationQuery;

	private boolean testWhileIdle;

	private boolean testOnBorrow;

	private boolean testOnReturn;

	private boolean poolPreparedStatements;

	private int maxPoolPreparedStatementPerConnectionSize;

	private String filters;

	private String connectionProperties;

	/**
	 * 配置数据库连接池
	 * 
	 * @return
	 */
	@Bean(name = "firstDataSourace")
	@Primary // 当一个接口有多个实现类时，加上这个注解表明，要加载这个实现类
	public DataSource dataSourace() {

		DruidDataSource dataSourace = new DruidDataSource();
		// 基本配置
		dataSourace.setUrl(jdbcUrl);
		dataSourace.setUsername(username);
		dataSourace.setPassword(password);
		dataSourace.setDriverClassName(driverClass);
		dataSourace.setDbType(dbType);

		// 连接池配置
		dataSourace.setInitialSize(initialSize);//初始化时建立物理连接的个数
		dataSourace.setMinIdle(minIdle);//最小空闲连接数
		dataSourace.setMaxActive(maxActive);//最大连接数量
		dataSourace.setMaxWait(maxWait);//超时等待时间以毫秒为单位 1000等于60秒
		dataSourace.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		dataSourace.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		dataSourace.setValidationQuery(validationQuery);
		dataSourace.setTestWhileIdle(testWhileIdle);
		dataSourace.setTestOnBorrow(testOnBorrow);
		dataSourace.setTestOnReturn(testOnReturn);
		dataSourace.setPoolPreparedStatements(poolPreparedStatements);
		dataSourace.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
		
		try {
			dataSourace.setFilters(filters);
		} catch (SQLException e) {
			logger.error("druid configuration initialization filter", e);
		}
		dataSourace.setConnectionProperties(connectionProperties);

		return dataSourace;
	}
	
	@Bean(name="firstSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("firstDataSourace") DataSource dataSource) throws Exception {
		
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource);
		
		sessionFactory.setTypeAliasesPackage("com.example.domain.firstdomain");
		
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		sessionFactory.setMapperLocations(resolver.getResources("classpath:com/haitun/firstDaoMapper/*.xml"));
		sessionFactory.setConfigLocation(resolver.getResource("classpath:com/haitun/mybatis-transferwedeu-config.xml"));
		
		 //分页插件  
        PageHelper pageHelper = new PageHelper();  
        Properties props = new Properties();  
        props.setProperty("reasonable", "true");  
        props.setProperty("supportMethodsArguments", "true");  
        props.setProperty("returnPageInfo", "check");  
        props.setProperty("params", "count=countSql");
        props.setProperty("rowBoundsWithCount", "true");
        props.setProperty("pageSizeZero", "true");
        
        pageHelper.setProperties(props);  
        
        sessionFactory.setPlugins(new Interceptor[]{pageHelper});
        
        return sessionFactory.getObject();
	}
	
	@Bean(name="firstTransactionManager")
	public DataSourceTransactionManager transactionManager(@Qualifier("firstDataSourace") DataSource dataSource){
		
		 return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean(name="firstSqlSessionTemplete")
	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("firstSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
		
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	/**读取配置的 get set 方法*/

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public int getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}

	public int getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public int getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}

	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public boolean isTestOnReturn() {
		return testOnReturn;
	}

	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	public boolean isPoolPreparedStatements() {
		return poolPreparedStatements;
	}

	public void setPoolPreparedStatements(boolean poolPreparedStatements) {
		this.poolPreparedStatements = poolPreparedStatements;
	}

	public int getMaxPoolPreparedStatementPerConnectionSize() {
		return maxPoolPreparedStatementPerConnectionSize;
	}

	public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
		this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
	}

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	public String getConnectionProperties() {
		return connectionProperties;
	}

	public void setConnectionProperties(String connectionProperties) {
		this.connectionProperties = connectionProperties;
	}
	
	
}
