package com.hanxiaocu.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/19 11:23 AM
 */

@Configuration
@MapperScan(basePackages = "com.hanxiaocu.mybatis.db2.dao",sqlSessionTemplateRef = "db2SqlSessionTemplate")
public class DataSource2Config {

	@Bean(name = "db2DataSource")
	@ConfigurationProperties(prefix = "spring.datasource.hikari.db2")
	public DataSource db2DataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "db2SqlSessionFactory")
	public SqlSessionFactory db2SqlSessionFactory(@Qualifier("db2DataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		return bean.getObject();
	}

	@Bean("db2TransactionManager")
	public DataSourceTransactionManager db2TransactionManager(@Qualifier("db2DataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean("db2SqlSessionTemplate")
	public SqlSessionTemplate db2SqlSessionTemplate(@Qualifier("db2SqlSessionFactory") SqlSessionFactory factory){
		return new SqlSessionTemplate(factory);
	}
}
