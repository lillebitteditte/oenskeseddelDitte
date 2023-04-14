package com.example.oenskeseddel.Repository;

import com.example.oenskeseddel.Model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;


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
