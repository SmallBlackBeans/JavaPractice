package com.hanxiaocu.sample.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/25 3:32 PM
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "datasource")
    @Profile("test")
    public DataSource testDataSource(Environment env) {
        HikariDataSource test = getDataSource(env);
        test.setMaximumPoolSize(10);
        return test;
    }


    @Bean(name = "datasource")
    @Profile("dev")
    public DataSource devDataSource(Environment env) {
        HikariDataSource dev = getDataSource(env);
        dev.setMaximumPoolSize(50);
        return dev;
    }

    @Bean(name = "datasource")
    @Profile("prod")
    public DataSource prodDataSource(Environment env) {
        HikariDataSource prod = getDataSource(env);
        prod.setMaximumPoolSize(200);
        return prod;
    }


    private HikariDataSource getDataSource(Environment env) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
        ds.setUsername(env.getProperty("spring.datasource.username"));
        ds.setPassword(env.getProperty("spring.datasource.password"));
        ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        return ds;
    }
}
