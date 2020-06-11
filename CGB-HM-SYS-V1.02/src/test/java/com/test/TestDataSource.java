package com.test;


import javax.sql.DataSource;

import org.junit.Test;

public class TestDataSource extends TestBase {

	@Test
	public void testDruidDataSource() throws Exception{
		DataSource ds = ctx.getBean("dataSource", DataSource.class);
		System.out.println(ds.getConnection());
	}
}
