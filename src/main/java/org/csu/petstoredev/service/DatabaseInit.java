package org.csu.petstoredev.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseInit {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @PostConstruct
    public void init() {
            jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS cart(" +
                    "            username VARCHAR(25) PRIMARY KEY NOT NULL ," +
                    "            itemid VARCHAR(10) NOT NULL," +
                    "            quantity INTEGER NOT NULL" +
                    "    )");
    }
}
