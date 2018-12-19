package com.hanxiaocu.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/19 11:23 AM
 */
@Configuration
@MapperScan(basePackages = "com.hanxiaocu.mybatis.db1.dao",sqlSessionTemplateRef = "db1SqlSessionTemplate")
public class DataSource1Config {

	@Bean(name = "db1DataSource")
	@ConfigurationProperties(prefix = "spring.datasource.hikari.db1")
	@Primary//表明这是默认的数据库
	public DataSource defaultDataSource(){
		return DataSourceBuilder.create().build();
	}

	/**
	 * 创建SqlSessionFactory
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "db1SqlSessionFactory")
	@Primary
	public SqlSessionFactory defaultSqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		// bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/db1/*xml"));
		return bean.getObject();
	}

	/**
	 * 配置事务管理
	 * @param dataSource
	 * @return
	 */
	@Bean(name = "db1TransactionManager")
	@Primary
	public DataSourceTransactionManager defaultTransactionManage(@Qualifier("db1DataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "db1SqlSessionTemplate")
	@Primary
	public SqlSessionTemplate defaultSqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory factory) {
		return new SqlSessionTemplate(factory);
	}



}
