package com.example.oenskeseddel.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class LoginRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public LoginRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public boolean checkLogin(String brugernavn) {
        String sql = "SELECT* FROM bruger WHERE brugernavn=?";
        Object[] params = {brugernavn};
        int count = jdbcTemplate.queryForObject(sql, params, Integer.class);
        return count > 0;
    }
}
