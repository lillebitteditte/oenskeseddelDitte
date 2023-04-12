package com.example.oenskeseddel.Repository;

import com.example.oenskeseddel.Model.Bruger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrugerRepo {
    // This method will add a wish.
    @Autowired
    JdbcTemplate template;

    public List<Bruger> fetchAll() {
        String sql = "SELECT* FROM bruger";
        RowMapper<Bruger> rowMapper = new BeanPropertyRowMapper<>(Bruger.class);
        return template.query(sql, rowMapper);
    }



    // This method will update the wish.


    // This method will delete the user.


    // This method will update the user.
    public void updateBruger(int id, Bruger a) {

    }


}
