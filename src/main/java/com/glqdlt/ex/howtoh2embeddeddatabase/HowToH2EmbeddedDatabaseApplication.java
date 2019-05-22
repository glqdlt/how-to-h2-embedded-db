package com.glqdlt.ex.howtoh2embeddeddatabase;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class HowToH2EmbeddedDatabaseApplication implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(HowToH2EmbeddedDatabaseApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        String url = dataSource.getUrl();
        if (!url.equals("jdbc:h2:file:~/local/file_db;")) {
            log.error("입력 된 URL {}", url);
            throw new RuntimeException("잘못 로드 된 DataSource");
        }
    }
}
