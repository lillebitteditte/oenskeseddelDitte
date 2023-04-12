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





    // This method will update the wish.


    // This method will delete the user.


    // This method will update the user.
    public void updateBruger(int id, Bruger a) {

    }


}
