package com.hm.common.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource("classpath:configs.properties")
public class AppDataSourceConfig {
	@Lazy(true)
	@Bean(value="dataSource",initMethod="init",destroyMethod="close")
	public DataSource newDruidDataSource(Environment en){
		DruidDataSource d = new DruidDataSource();
		d.setDriverClassName(en.getProperty("jdbcDriver"));
		d.setUrl(en.getProperty("jdbcUrl"));
		d.setUsername(en.getProperty("jdbcUser"));
		d.setPassword(en.getProperty("jdbcPassword"));
		return d;
	}
}
