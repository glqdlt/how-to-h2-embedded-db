package com.glqdlt.ex.howtoh2embeddeddatabase;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class HowToH2EmbeddedDatabaseApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getDataSource() {
        Object dataSource = applicationContext.getBean("dataSource");
        String url = ((DataSource) dataSource).getUrl();
        Assert.assertEquals("jdbc:h2:mem:memory_db;", url);
    }
}
