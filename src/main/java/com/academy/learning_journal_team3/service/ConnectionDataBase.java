package com.academy.learning_journal_team3.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class ConnectionDataBase {
    private final JdbcTemplate jdbcTemplate;
        public ConnectionDataBase (JdbcTemplate jdbcTemplate){
            this.jdbcTemplate = jdbcTemplate;
        }
        public List<Map<String, Object>> getAllEntries() {
            return jdbcTemplate.queryForList("SELECT * FROM TEST_TABLE");

        }public void insertEntry(int id, String name){
                jdbcTemplate.update("INSERT INTO TEST_TABLE (ID, NAME) VALUES (?,?)", id, name);
            }
        }
//avahsghas